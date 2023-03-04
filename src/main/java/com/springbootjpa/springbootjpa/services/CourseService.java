package com.springbootjpa.springbootjpa.services;

import java.util.List;

import com.springbootjpa.springbootjpa.entity.Course;

public interface CourseService {
    Course loadCourseById(Long courseId);
    Course createCourse(String courseName, String courseDuration, String courseDescription, Long instructorId);
    Course createOrUpdateCourse(Course course);
    List<Course> findCourseByCourseName(String keyword);
    void assignStudentToCourse(Long courseId,Long studentId);
    List<Course> fetchAll();
    List<Course> fetchCoursesForStudents(Long studentId);
    void removeCourse(Long courseId);
}
