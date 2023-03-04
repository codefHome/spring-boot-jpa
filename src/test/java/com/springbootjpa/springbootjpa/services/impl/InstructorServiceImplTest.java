package com.springbootjpa.springbootjpa.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
 
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.springbootjpa.springbootjpa.dao.InstructorDao;
import com.springbootjpa.springbootjpa.dao.UserDao;
import com.springbootjpa.springbootjpa.entity.Course;
import com.springbootjpa.springbootjpa.entity.Instructor;
import com.springbootjpa.springbootjpa.entity.User;

import jakarta.persistence.EntityNotFoundException;

@ExtendWith(MockitoExtension.class)
public class InstructorServiceImplTest {
    
@Mock
private InstructorDao instructorDao;

@InjectMocks
 InstructorServiceImpl instructorService;

@Mock
private UserServiceImpl userService;

@Mock
private CourseServiceImp courseService;
    @Test
    void testLoadInstructorById(){
Instructor instructor = new Instructor();
instructor.setInstructorId(2L);
when(instructorDao.findById(anyLong())).thenReturn(Optional.of(instructor));
Instructor actualInstructor= instructorService.loadInstructorById(2L);

assertEquals(instructor, actualInstructor);
    }

    @Test
    void testInstructorNotFoundException(){
        assertThrows(EntityNotFoundException.class,()-> instructorService.loadInstructorById(2L));
    }

    @Test
    void testLoadInstructorByEmail(){
        // Instructor instructor = new Instructor();
        // instructor.setInstructorId(2L);
        // when(instructorDao.findInstructorByEmail(anyString())).thenReturn(instructor);

        // Instructor actualInstructor= instructorService.loadInstructorByEmail("instructor@gmail.com");
        // assertEquals(instructor, actualInstructor);

        String email="instructor@gmail.com";
        instructorService.loadInstructorByEmail(email);
        verify(instructorDao).findInstructorByEmail(email);
    }

    @Test
    void testFindInstructorByName(){
        String instructorName="InstructorName";
       instructorService.findInstructorsByName(instructorName);
        verify(instructorDao).findInstructorsByName(instructorName);
        
    }

    @Test
    void testCreateInstructor(){
User user = new User("instUser@gmail.com","test");
when(userService.createUser(anyString(), anyString())).thenReturn(user);
instructorService.createInstructor("instFn", "instLN", "Senior", "instUser@gmail.com", "test");

verify(instructorDao).save(any());

    }

    @Test
    void testUpdateInstructor(){
        Instructor instructor = new Instructor();
        instructor.setInstructorId(1L);
        instructorService.updateInstructor(instructor);
        verify(instructorDao).save(instructor);
    }

    @Test
    void testFetchInstructor(){
instructorService.fetchInstructors();
verify(instructorDao).findAll();
    }

    @Test
    void testRemoveCourse(){
        Course course = new Course();
        course.setCourseId(2L);
        Instructor instructor = new Instructor();
        instructor.setInstructorId(1L);
        instructor.getCourses().add(course);
        when(instructorDao.findById(anyLong())).thenReturn(Optional.of(instructor));

        instructorService.removeInstructor(1L);

        verify(courseService).removeCourse(anyLong());
        verify(instructorDao,times(1)).deleteById(anyLong());
    }

      
}
