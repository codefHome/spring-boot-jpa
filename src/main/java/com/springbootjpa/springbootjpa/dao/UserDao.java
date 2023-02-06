package com.springbootjpa.springbootjpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootjpa.springbootjpa.entity.User;

public interface UserDao extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
