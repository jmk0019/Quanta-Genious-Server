package com.quantaGenious.spring.login.payload.response;

import java.util.List;

public class UserInfoResponse {
	
	private int userId;
	private String username;
	private String email;
	private List<String> roles;

	public UserInfoResponse(int userId, String username, String email, List<String> roles) {
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.roles = roles;
	}

	

	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public void setRoles(List<String> roles) {
		this.roles = roles;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return roles;
	}
}
