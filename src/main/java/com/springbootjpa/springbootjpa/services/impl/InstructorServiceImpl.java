package com.springbootjpa.springbootjpa.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springbootjpa.springbootjpa.dao.InstructorDao;
import com.springbootjpa.springbootjpa.entity.Course;
import com.springbootjpa.springbootjpa.entity.Instructor;
import com.springbootjpa.springbootjpa.entity.User;
import com.springbootjpa.springbootjpa.services.CourseService;
import com.springbootjpa.springbootjpa.services.InstructorService;
import com.springbootjpa.springbootjpa.services.UserService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
@Service
@Transactional
public class InstructorServiceImpl implements InstructorService {

    private InstructorDao instructorDao;
    private CourseService courseService;
    private UserService userService;
    
    public InstructorServiceImpl(InstructorDao instructorDao, CourseService courseService,UserService userService) {
        this.instructorDao = instructorDao;
        this.courseService = courseService;
        this.userService  = userService;

    }

    @Override
    public Instructor createInstructor(String firstName, String lastName, String summary, String email,
            String password) {
        User user= userService.createUser(email, password);
        userService.assignRolesToUsers(email, "Instructor");
        return instructorDao.save(new Instructor(firstName,lastName,summary,user));
    }

    @Override
    public List<Instructor> fetchInstructors() {
       return instructorDao.findAll();  
    }

    @Override
    public List<Instructor> findInstructorsByName(String name) {
       
        return instructorDao.findInstructorsByName(name);
    }

    @Override
    public Instructor loadInstructorByEmail(String email) {
       return instructorDao.findInstructorByEmail(email);
    }

    @Override
    public Instructor loadInstructorById(Long instructorId) {
        return instructorDao.findById(instructorId).orElseThrow(()-> new EntityNotFoundException("Instructor with id "+ instructorId+ "Not Found"));
    }

    @Override
    public void removeInstructor(Long instructorId) {
        Instructor instructor = loadInstructorById(instructorId);
        for(Course course: instructor.getCourses()){
            courseService.removeCourse(course.getCourseId());
        }

       instructorDao.deleteById(instructorId);
        
    }

    @Override
    public Instructor updateInstructor(Instructor instructor) {
      return instructorDao.save(instructor);
    }
    
}
