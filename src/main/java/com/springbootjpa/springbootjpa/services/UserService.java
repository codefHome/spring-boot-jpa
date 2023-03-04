package com.springbootjpa.springbootjpa.services;

import com.springbootjpa.springbootjpa.entity.User;

public interface UserService {
    User loadUserByEmail(String email);
    User createUser(String email,String password);
    void assignRolesToUsers(String email,String roleName);
}
