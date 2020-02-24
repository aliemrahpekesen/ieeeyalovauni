package com.yalova.ieee.yemekhane.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.yalova.ieee.yemekhane.model.User;

@Service
public class UserService {

	ArrayList<User> userList = new ArrayList<User>();

	public User CreateUser(User userObject) {
		this.userList.add(userObject);
		return userObject;
	}

	public User RetrieveUserById(int id) {
		User foundUser = null;
		for (User user : userList) {
			if (user.getId() == id) {
				foundUser = user;
				break;
			}
		}

		return foundUser;
	}

	public ArrayList<User> RetrieveAll() {
		return this.userList;
	}

	public void UpdateUser(User newUser) {
		User userToBeUpdated = RetrieveUserById(newUser.getId());
		userToBeUpdated = newUser;
	}

	public void DeleteUser(int id) {
		User userToBeDeleted = RetrieveUserById(id);
		this.userList.remove(userToBeDeleted);
	}

}
