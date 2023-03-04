package com.springbootjpa.springbootjpa.services;

import java.util.List;

import com.springbootjpa.springbootjpa.entity.Student;

public interface StudentService {
    Student loadStudyById(Long studentId);
    List<Student> findStudentByName(String name);
    Student loadStudentByEmail(String email);
    Student createStudent(String firstName,String lastName, String level, String email, String password);
    Student updateStudent(Student student);
    List<Student> fetchStudent();
    void removeStudent(Long studentId);
}
