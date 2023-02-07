package com.springbootjpa.springbootjpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springbootjpa.springbootjpa.entity.Course;

public interface CourseDao extends JpaRepository<Course,Long> {
    List<Course> findCoursesByCourseNameContains(String keyword);

    @Query(value="select * from springboot.courses as c where c.course_id in (select e.course_id from springboot.enrolled_in as e where e.student_id=:studentId )", nativeQuery = true)
    List<Course> getCoursesByStudentId(@Param("studentId") Long studentId);
    
}
