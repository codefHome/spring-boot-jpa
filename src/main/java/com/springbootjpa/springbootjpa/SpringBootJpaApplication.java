package com.springbootjpa.springbootjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootjpa.springbootjpa.dao.CourseDao;
import com.springbootjpa.springbootjpa.dao.InstructorDao;
import com.springbootjpa.springbootjpa.dao.RoleDao;
import com.springbootjpa.springbootjpa.dao.StudentDao;
import com.springbootjpa.springbootjpa.dao.UserDao;
import com.springbootjpa.springbootjpa.utility.OperationUtility;

@SpringBootApplication
@RequestMapping("check")
@RestController
public class SpringBootJpaApplication implements CommandLineRunner{
@Autowired
private UserDao userDao;
@Autowired
private CourseDao courseDao;

@Autowired
private InstructorDao instructorDao;
@Autowired
private RoleDao roleDao;
@Autowired
private StudentDao studentDao;



	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaApplication.class, args);
	}

	@GetMapping
	public String helloWorld(){
		return "Hello world";
	}

	@Override
	public void run(String... args) throws Exception {
		
	
		// OperationUtility.usersOperations(userDao);
		// OperationUtility.rolesOPerations(roleDao);
		//  OperationUtility.assignRolesToUsers(userDao, roleDao);
		// OperationUtility.instructorsOperations(userDao, instructorDao, roleDao);
		// OperationUtility.studentOperations(userDao, studentDao, roleDao);
		OperationUtility.coursesOperation(courseDao, instructorDao, studentDao);

	}

}
