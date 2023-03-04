package com.springbootjpa.springbootjpa.services.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.springbootjpa.springbootjpa.dao.RoleDao;
import com.springbootjpa.springbootjpa.entity.Role;

@ExtendWith(MockitoExtension.class)
public class RoleServiceImplTest {
    @Mock
    private RoleDao roleDao;
    @InjectMocks
    RoleServiceImpl roleService;

@Test
void testCreateRole(){
 roleService.createRole("Admin");
 verify(roleDao,times(1)).save(any());
}

@Test
void testLoadRoleByName(){

    roleService.loadRoleByName("Admin");
    verify(roleDao).findByName(anyString());
}
    
}
