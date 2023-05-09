package com.velue.services;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import com.velue.dto.User;

public interface UserService {

	public List<User> getAllUsers();

	public User getUserById(Long id);

	public User addUser(User user);

	public User updateUser(User user);

	public void deleteUser(Long id);
	
	public User disableUser(User user) ;
    public List<User> searchUsers()  ;
    
  



}
