package com.springbootjpa.springbootjpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springbootjpa.springbootjpa.entity.Course;
import com.springbootjpa.springbootjpa.entity.Instructor;
import com.springbootjpa.springbootjpa.entity.Student;
import com.springbootjpa.springbootjpa.entity.User;
import com.springbootjpa.springbootjpa.services.CourseService;
import com.springbootjpa.springbootjpa.services.InstructorService;
import com.springbootjpa.springbootjpa.services.RoleService;
import com.springbootjpa.springbootjpa.services.StudentService;
import com.springbootjpa.springbootjpa.services.UserService;


@SpringBootApplication
// @RequestMapping("check")
// @RestController
public class SpringBootJpaApplication {
/* @Autowired
private UserDao userDao;
@Autowired
private CourseDao courseDao;

@Autowired
private InstructorDao instructorDao;
@Autowired
private RoleDao roleDao;
@Autowired
private StudentDao studentDao; */

/* public static final String ADMIN="Admin";
public static final String INSTRUCTOR="Instructor";
public static final String STUDENT="Student"; */

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaApplication.class, args);
	}

	/* @GetMapping
	public String helloWorld(){
		return "Hello world";
	} */

/* @Bean
CommandLineRunner start(UserService userService, RoleService roleService, StudentService studentService, InstructorService instructorService,CourseService courseService ){
	return args ->{
		User user1=userService.createUser("user1@gmail.com", "pass1");
		User user2=userService.createUser("user2@gmail.com", "pass2");

roleService.createRole(ADMIN);
roleService.createRole(INSTRUCTOR);
roleService.createRole(STUDENT);

userService.assignRolesToUsers(user1.getEmail(), ADMIN);
userService.assignRolesToUsers(user1.getEmail(), INSTRUCTOR);
userService.assignRolesToUsers(user2.getEmail(), STUDENT);

Instructor instructor1= instructorService.createInstructor("instructor1FN", "Instructor1LN", "Experienced", "instructorUser1@gmail.com", "pass1");
Instructor instructor2= instructorService.createInstructor("instructor2FN", "Instructor2LN", "Senior", "instructorUser2@gmail.com", "pass2");

Student student1= studentService.createStudent("std1FN", "std2LN", "Master", "stdUser1@gmail.com", "pass1");
Student student2= studentService.createStudent("std2FN", "std2LN", "Phd", "stdUser2@gmail.com", "pass2");

Course course1= courseService.createCourse("spring service", "10 Hours", "Master spring boot", instructor1.getInstructorId());
Course course2= courseService.createCourse("spring jpa", "20 Hours", "Master jpa", instructor2.getInstructorId());

courseService.assignStudentToCourse(course1.getCourseId(),student1.getStudentId());
courseService.assignStudentToCourse(course2.getCourseId(),student2.getStudentId());







	}; */
}


	/* @Override
	public void run(String... args) throws Exception { //first need to implements commandLineRunner
		
	

	} */

// }
