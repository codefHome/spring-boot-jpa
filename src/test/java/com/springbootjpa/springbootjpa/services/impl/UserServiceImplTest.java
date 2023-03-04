package com.springbootjpa.springbootjpa.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.springbootjpa.springbootjpa.dao.RoleDao;
import com.springbootjpa.springbootjpa.dao.UserDao;
import com.springbootjpa.springbootjpa.entity.Role;
import com.springbootjpa.springbootjpa.entity.User;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
    
@Mock
private UserDao userDao;
@Mock
private RoleDao roleDao;
@Mock
private RoleServiceImpl roleService;
@Mock
private User mockedUser;
@InjectMocks
UserServiceImpl userService;

    @Test
   void testLoadUserByEmail(){
userService.loadUserByEmail(anyString());
verify(userDao,times(1)).findByEmail(anyString());
    }
    @Test
    void testCreateUser(){
String email="user@gmail.com";
String password= "test";
User user = new User(email,password);
userService.createUser(email, password);
ArgumentCaptor<User> argumentCaptor = ArgumentCaptor.forClass(User.class);
verify(userDao).save(argumentCaptor.capture());

User capturedUser = argumentCaptor.getValue();
assertEquals(user, capturedUser);

    }

@Test
void testAssignRolesToUsers(){
Role role =new Role();
role.setRoleId(1L);
User user = new User();
user.setUserId(2L);
user.getRoles().add(role);

when(roleDao.findByName(anyString())).thenReturn(role);
when(userDao.findByEmail(anyString())).thenReturn(mockedUser);

userService.assignRolesToUsers("user@gmail.com", "test");
verify(mockedUser,times(1)).assignRoleToUser(role);
}
}
