package com.springbootjpa.springbootjpa.services;

import com.springbootjpa.springbootjpa.entity.Role;

public interface RoleService {
    
    Role loadRoleByName(String roleName);
    Role createRole(String roleName);
    
}
