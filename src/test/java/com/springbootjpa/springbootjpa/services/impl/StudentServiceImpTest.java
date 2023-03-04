package com.springbootjpa.springbootjpa.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.springbootjpa.springbootjpa.dao.CourseDao;
import com.springbootjpa.springbootjpa.dao.StudentDao;
import com.springbootjpa.springbootjpa.dao.UserDao;
import com.springbootjpa.springbootjpa.entity.Course;
import com.springbootjpa.springbootjpa.entity.Student;
import com.springbootjpa.springbootjpa.entity.User;

@ExtendWith(MockitoExtension.class)
public class StudentServiceImpTest {
    @Mock
    private StudentDao studentDao;

    @InjectMocks
    private StudentServiceImp studentService;
    @Mock
    private UserDao userDao;
    @Mock
    private UserServiceImpl userService;
    @Mock
    private Student mockedStudent;
    @Mock
    private Course mockedCourse;
    @Mock
    private CourseDao courseDao;

    @Test
    void testLoadStudentById(){
        Student student = new Student();
        student.setStudentId(22L);
        when(studentDao.findById(2L)).thenReturn(Optional.of(student));
        Student actualStudent = studentService.loadStudyById(2L);
        assertEquals(student, actualStudent);

    }

    @Test
    void testFindStudentByName(){
        studentService.findStudentByName("John");
        verify(studentDao,times(1)).findStudentByName("John");
    }

    @Test
    void testLoadstudentByEmail(){
        String email="student@gmail.com";
        studentService.loadStudentByEmail(email);
        verify(studentDao).findStudentByEmail(email);
    }
@Test
void testCreateStudent(){
User user = new User();
user.setEmail("student@gmails.com");
user.setPassword("test");
when(userService.createUser("student@gmail.com", "test")).thenReturn(user);

studentService.createStudent("stdFN", "stdLN", "Master", "student@gmail.com", "test");
verify(studentDao).save(any());
}
@Test
void testUpdateStudent(){
    Student student = new Student();
    student.setStudentId(2L);
    studentService.updateStudent(student);
    verify(studentDao).save(student);
}

@Test
void testFetchStudent(){
    studentService.fetchStudent();
    verify(studentDao).findAll();
}

@Test
void testRemoveStudent(){
Student student = new Student();
Course course = new Course();
student.setStudentId(2L);
student.getCourses().add(course);
when(studentDao.findById(anyLong())).thenReturn(Optional.of(student));

studentService.removeStudent(2L);
mockedCourse.removeStudentFromCourse(student);
verify(mockedCourse,times(1)).removeStudentFromCourse(student);
verify(studentDao).deleteById(anyLong());
}
}
