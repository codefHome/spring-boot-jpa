package com.springbootjpa.springbootjpa.services.impl;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springbootjpa.springbootjpa.dao.CourseDao;
import com.springbootjpa.springbootjpa.dao.InstructorDao;
import com.springbootjpa.springbootjpa.dao.StudentDao;
import com.springbootjpa.springbootjpa.entity.Course;
import com.springbootjpa.springbootjpa.entity.Instructor;
import com.springbootjpa.springbootjpa.entity.Student;
import com.springbootjpa.springbootjpa.services.CourseService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
@Service
@Transactional
public class CourseServiceImp implements CourseService {
private InstructorDao instructorDao;
private CourseDao courseDao;
private StudentDao studentDao;



    public CourseServiceImp(InstructorDao instructorDao, CourseDao courseDao,StudentDao studentDao) {
    this.instructorDao = instructorDao;
    this.courseDao = courseDao;
    this.studentDao=studentDao;
}

    @Override
    public void assignStudentToCourse(Long courseId, Long studentId) {
      Course course= courseDao.findById(courseId).orElseThrow(()->new EntityNotFoundException("Course with Id" + courseId + "Not Found"));
      Student student=studentDao.findById(studentId).orElseThrow(()-> new EntityNotFoundException("Student with Id "+ studentId + "Not Found"));
        course.assignStudentToCourse(student);
    }

    @Override
    public Course createCourse(String courseName, String courseDuration, String courseDescription, Long instructorId) {
        Instructor instructor = instructorDao.findById(instructorId).orElseThrow(()-> new EntityNotFoundException("Instructor with id"+ instructorId + "Not Found"));
       return courseDao.save(new Course(courseName,courseDuration,courseDescription,instructor));
    }

    @Override
    public Course createOrUpdateCourse(Course course) {
        return courseDao.save(course);
    }

    @Override
    public List<Course> fetchAll() {
       return courseDao.findAll();
    }

    @Override
    public List<Course> fetchCoursesForStudents(Long studentId) {
      return courseDao.getCoursesByStudentId(studentId);
    }

    @Override
    public List<Course> findCourseByCourseName(String keyword) {
       
        return courseDao.findCoursesByCourseNameContains(keyword);
    }

    @Override
    public Course loadCourseById(Long courseId) {
        
        return courseDao.findById(courseId).orElseThrow(() -> new EntityNotFoundException("Course with id" + courseId + "Not Found"));
    }

    @Override
    public void removeCourse(Long courseId) {
       courseDao.deleteById(courseId);   
    }
    
}
