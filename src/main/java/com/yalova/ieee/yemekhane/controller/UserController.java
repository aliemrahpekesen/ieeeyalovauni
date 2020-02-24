package com.yalova.ieee.yemekhane.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yalova.ieee.yemekhane.model.User;
import com.yalova.ieee.yemekhane.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public User addUser(@RequestBody User newUser) {
		return this.userService.CreateUser(newUser);
	}

	@GetMapping
	public ArrayList<User> getAllUsers() {
		return this.userService.RetrieveAll();
	}

	@GetMapping("/{userId}")
	public User getUserById(@PathVariable String userId) throws Exception {
		int idToBeFind = Integer.valueOf(userId);
		User foundUser = this.userService.RetrieveUserById(idToBeFind);
		if (foundUser == null) {
			throw new Exception("Resource Not Found!");
		}
		return foundUser;
	}

	@DeleteMapping("/{userId}")
	public String deleteUserById(@PathVariable String userId) throws Exception {
		int idToBeDeleted = Integer.valueOf(userId);
		this.userService.DeleteUser(idToBeDeleted);
		return "User is deleted by given Id";
	}

}
