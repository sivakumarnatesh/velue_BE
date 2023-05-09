package com.velue.services;

import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.velue.dao.RoleRepository;
import com.velue.dto.Order;
import com.velue.dto.Role;

@Service
public class RoleServiceImpl implements RoleService {

	private RoleRepository roleRepository;

	@Autowired
	public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	public List<Role> getAllRoles() {

		return roleRepository.findAll();
	}

	public Role addRole(Role role) {
		return roleRepository.save(role);
	}
	
	public Role getRoleById(Long id) {
		Role role = roleRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Role not found with id " + id));
		return role;
	}

}
