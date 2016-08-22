package com.dao.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable{
	private String userName = null;
	private String password = null;
	private String role = null ;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

}
