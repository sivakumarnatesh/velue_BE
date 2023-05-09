package com.velue.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.velue.dto.Customer;
import com.velue.dto.Role;
import com.velue.dto.User;
import com.velue.dto.UserList;
import com.velue.services.RoleService;
import com.velue.services.UserService;

/*
Get all users: GET /api/users
Get a specific user by ID: GET /api/users/{userId}
Create a new user: POST /api/users
Update a user by ID: PUT /api/users/{userId}
Delete a user by ID: DELETE /api/users/{userId}
Search users by name or email: GET /api/users?name={name}&email={email}
 */
@RestController
@RequestMapping("/user/")
public class UserController {

	private UserService userService;
	private RoleService roleService;


	@Autowired
	public UserController(UserService userService,RoleService roleService)
	{
		this.userService = userService;
		this.roleService = roleService;
		
	}

	//start 
	
	@GetMapping("/getAllUsers")
	public List<UserList> getAllUsers() {
		List<User> users = userService.getAllUsers();
		List<UserList> userList = new ArrayList<>();

		for (User user : users) {
			Role role = roleService.getRoleById(user.getUserRoleId());
			UserList userList1 = new UserList();
			userList1.setUserId(user.getUserId());
			userList1.setEmaildID(user.getEmailId());
			userList1.setUserRoleName(role.getRoleName());
			userList1.setUserStatus(user.getUserStatus());
			userList1.setUserName(user.getUserName());
			userList.add(userList1);

		}

		return userList;
		// return userService.getAllUsers();
	}

	//end

	@GetMapping("/{id}")
	public User getuserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}

	@PostMapping("/add")
	public User addUser(@RequestBody User user) {
		System.out.println("adduser"+user.getFirstName());
		return userService.addUser(user);
	}

	@PutMapping("/update/{id}")
	public User updateuser(@PathVariable Long id, @RequestBody User user) {
		User existinguser = userService.getUserById(id);
		existinguser.setUserName(user.getUserName());
		existinguser.setFirstName(user.getFirstName());
		existinguser.setLastName(user.getLastName());
		existinguser.setPhoneNumber(user.getPhoneNumber());
		existinguser.setEmailId(user.getEmailId());
		//existinguser.setUserRole(user.getUserRole());
		existinguser.setUserPassword(user.getUserPassword());
		
		existinguser.setUserStatus(user.getUserStatus());
		return userService.updateUser(existinguser);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteuser(@PathVariable Long id) {
		userService.deleteUser(id);
	}

	// for disable 
	@PutMapping("/disable/{id}")
	public User disableuser(@PathVariable Long id, @RequestBody User user) {
		User existinguser = userService.getUserById(id);
		
		existinguser.setUserStatus(user.getUserStatus());
		return userService.updateUser(existinguser);
	}
	
	//for searching 
	@GetMapping("/search")
	 public List<User> searchUsers(
			      @RequestParam(required = false) String userName,
			      @RequestParam(required = false) String firstName,
			      @RequestParam(required = false) String lastName,
			    //  @RequestParam(required = false) Long userRoleId,
			      @RequestParam(required = false) String userStatus
			      // include other parameters here
			  ) {
			    List<User> users = userService.searchUsers();

			    if (userName != null) {
			      users = users.stream()
			          .filter(user -> user.getUserName().equals(userName))
			          .collect(Collectors.toList());
			    }

			    if (firstName != null) {
			      users = users.stream()
			          .filter(user -> user.getFirstName().equals(firstName))
			          .collect(Collectors.toList());
			    }

			    if (lastName != null) {
			      users = users.stream()
			          .filter(user -> user.getLastName().equals(lastName))
			          .collect(Collectors.toList());
			    }

				/*
				 * if (userRole != null) { users = users.stream() .filter(user ->
				 * user.getUserRole().equals(userRole)) .collect(Collectors.toList()); }
				 */

			    if (userStatus != null) {
			      users = users.stream()
			          .filter(user -> user.getUserStatus().equals(userStatus))
			          .collect(Collectors.toList());
			    }

			    // include other filters for other parameters

			    return users;
			  }
		
	
	

	
    }
	

