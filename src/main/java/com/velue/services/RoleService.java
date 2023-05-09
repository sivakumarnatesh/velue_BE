package com.velue.services;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.velue.dto.Role;


public interface RoleService {

    //roles
    
    public Role addRole(Role role);
    public List<Role> getAllRoles();
	public Role getRoleById(Long id);




}
