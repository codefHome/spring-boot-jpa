package com.springbootjpa.springbootjpa.services;

import java.util.List;

import com.springbootjpa.springbootjpa.entity.Instructor;

public interface InstructorService {
    Instructor loadInstructorById(Long instructorId);
    List<Instructor> findInstructorsByName(String name);
    Instructor loadInstructorByEmail(String email);
    Instructor createInstructor(String firstName, String lastName, String summary, String email, String password);
    Instructor updateInstructor(Instructor instructor);
    List<Instructor> fetchInstructors();
    void removeInstructor(Long instructorId);
}
