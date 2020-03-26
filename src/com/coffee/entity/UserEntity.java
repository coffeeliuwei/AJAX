package com.coffee.entity;

import java.io.Serializable;

public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;//1
	private String username;
	private String password;
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
