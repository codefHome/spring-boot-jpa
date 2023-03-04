package com.springbootjpa.springbootjpa.services.impl;

import org.springframework.stereotype.Service;

import com.springbootjpa.springbootjpa.dao.RoleDao;
import com.springbootjpa.springbootjpa.entity.Role;
import com.springbootjpa.springbootjpa.services.RoleService;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class RoleServiceImpl implements RoleService{
 
    private RoleDao roleDao;

    
    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role createRole(String roleName) {
      
        return roleDao.save(new Role(roleName));
    }

    @Override
    public Role loadRoleByName(String roleName) {
        
        return roleDao.findByName(roleName);
    }
    
}
