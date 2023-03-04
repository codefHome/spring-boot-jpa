package com.springbootjpa.springbootjpa.services.impl;

import org.springframework.stereotype.Service;

import com.springbootjpa.springbootjpa.dao.RoleDao;
import com.springbootjpa.springbootjpa.dao.UserDao;
import com.springbootjpa.springbootjpa.entity.Role;
import com.springbootjpa.springbootjpa.entity.User;
import com.springbootjpa.springbootjpa.services.UserService;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class UserServiceImpl implements UserService{
private UserDao userDao;
private RoleDao roleDao;


    public UserServiceImpl(UserDao userDao,RoleDao roleDao) {
    this.userDao = userDao;
    this.roleDao = roleDao;
    
}

    @Override
    public void assignRolesToUsers(String email, String roleName) {
       Role role= roleDao.findByName(roleName);
       User user=userDao.findByEmail(email);
       user.assignRoleToUser(role);
        
    }

    @Override
    public User createUser(String email, String password) {
      
        return userDao.save(new User(email,password));
    }

    @Override
    public User loadUserByEmail(String email) {
       return userDao.findByEmail(email);
    }
    
}
