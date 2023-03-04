package com.springbootjpa.springbootjpa.dao;

import com.springbootjpa.springbootjpa.AbstractTest;
import com.springbootjpa.springbootjpa.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Sql(scripts = {"file:src/test/resources/db/clearAll.sql","file:src/test/resources/db/springboot-admin-db.sql"})
class CourseDaoTest extends AbstractTest {

    @Autowired
    private CourseDao courseDao;
    @Test
    void findCoursesByCourseNameContains() {
       List<Course> courses= courseDao.findCoursesByCourseNameContains("Spring");
       int expectedResult=2;
       assertEquals(expectedResult,courses.size());
    }

    @Test
    void getCoursesByStudentId() {
    }
}