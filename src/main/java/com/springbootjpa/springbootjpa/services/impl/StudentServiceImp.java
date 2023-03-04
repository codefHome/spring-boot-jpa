package com.springbootjpa.springbootjpa.services.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springbootjpa.springbootjpa.dao.StudentDao;
import com.springbootjpa.springbootjpa.entity.Course;
import com.springbootjpa.springbootjpa.entity.Student;
import com.springbootjpa.springbootjpa.entity.User;
import com.springbootjpa.springbootjpa.services.StudentService;
import com.springbootjpa.springbootjpa.services.UserService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
@Service
@Transactional
public class StudentServiceImp implements StudentService{

private StudentDao studentDao;
private UserService userService;



    public StudentServiceImp(StudentDao studentDao,UserService userService) {
    this.studentDao = studentDao;
    this.userService = userService;
}

    @Override
    public Student createStudent(String firstName, String lastName, String level, String email, String password) {
     User user = userService.createUser(email, password);
     userService.assignRolesToUsers(email, "Student");
        return studentDao.save(new Student(firstName,lastName,level,user));
    }

    @Override
    public List<Student> fetchStudent() {
        return studentDao.findAll();
    }

    @Override
    public List<Student> findStudentByName(String name) {
        return studentDao.findStudentByName(name);
    }

    @Override
    public Student loadStudentByEmail(String email) {
        return studentDao.findStudentByEmail(email);
    }

    @Override
    public Student loadStudyById(Long studentId) {
        return studentDao.findById(studentId).orElseThrow(()-> new EntityNotFoundException("Student with Id "+ studentId + "Not Found"));
    }

    @Override
    public void removeStudent(Long studentId) {
        Student student = loadStudyById(studentId);
        Iterator<Course> iterator= student.getCourses().iterator();
        if(iterator.hasNext()){
            Course course= iterator.next();
            course.removeStudentFromCourse(student);
        }
        studentDao.deleteById(studentId);  
    }

    @Override
    public Student updateStudent(Student student) {
       return studentDao.save(student);
        
    }
    
}
