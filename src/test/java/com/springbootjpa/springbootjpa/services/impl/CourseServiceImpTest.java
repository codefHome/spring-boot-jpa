package com.springbootjpa.springbootjpa.services.impl;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.springbootjpa.springbootjpa.dao.CourseDao;
import com.springbootjpa.springbootjpa.dao.InstructorDao;
import com.springbootjpa.springbootjpa.dao.StudentDao;
import com.springbootjpa.springbootjpa.entity.Course;
import com.springbootjpa.springbootjpa.entity.Instructor;
import com.springbootjpa.springbootjpa.entity.Student;

import jakarta.persistence.EntityNotFoundException;
@ExtendWith(MockitoExtension.class)
public class CourseServiceImpTest {
    
@Mock
private CourseDao courseDao;
@Mock
private InstructorDao instructorDao;
@Mock
private StudentDao studentDao;
@InjectMocks
 CourseServiceImp courseService;


@Test
void testLoadCourseById(){
Course course = new Course();
course.setCourseId(1L);
when(courseDao.findById(any())).thenReturn(Optional.of(course));
Course actualCourse= courseService.loadCourseById(1L);
assertEquals(course, actualCourse);
}
@Test
void testExceptionForNotFoundCourseById(){
    assertThrows(EntityNotFoundException.class, ()-> courseService.loadCourseById(2L));
}

@Test
void createInstructor(){
Instructor instructor =new Instructor();
instructor.setInstructorId(2L);
when(instructorDao.findById(any())).thenReturn(Optional.of(instructor));
courseService.createCourse("spring boot", "3 hours", "advanced spring boot", 2L);
verify(courseDao).save(any());
}

@Test
void createOrUpdateCourse(){
    Course course= new Course();
    course.setCourseId(1L);
    courseService.createOrUpdateCourse(course);
    ArgumentCaptor<Course> argumentCaptor= ArgumentCaptor.forClass(Course.class);
    verify(courseDao).save(argumentCaptor.capture());
    Course capturedValue= argumentCaptor.getValue();
    assertEquals(course, capturedValue);

}
@Test
void findCoursesByCourseName(){
    String courseName="Jpa";
    courseService.findCourseByCourseName(courseName);
    verify(courseDao).findCoursesByCourseNameContains(courseName);
}

@Test
void assignStudentsToCourse(){
Student student= new Student();
student.setStudentId(2L);
Course course = new Course();
course.setCourseId(1L);

when(studentDao.findById(anyLong())).thenReturn(Optional.of(student));
when(courseDao.findById(anyLong())).thenReturn(Optional.of(course));

courseService.assignStudentToCourse(1L, 2L);
}

@Test
void fetchAll(){
    courseService.fetchAll();
    verify(courseDao).findAll();
}

@Test
void fetchCoursesForStudents(){
    courseService.fetchCoursesForStudents(2L);
    verify(courseDao).getCoursesByStudentId(2L);
}
@Test
void removeCourse(){
    courseService.removeCourse(2L);
    verify(courseDao).deleteById(2L);
}
}
