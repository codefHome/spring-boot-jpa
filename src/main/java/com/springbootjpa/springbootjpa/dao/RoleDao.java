package com.springbootjpa.springbootjpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootjpa.springbootjpa.entity.Role;

public interface RoleDao extends JpaRepository<Role,Long> {
    
    Role findByName(String name);
}
