package com.yalova.ieee.yemekhane.model;

import lombok.Data;

@Data
public class User {
	private int id;
	private String firstname;
	private String lastname;
	private GenderType gender;
	private String username;
	private String password;
}
