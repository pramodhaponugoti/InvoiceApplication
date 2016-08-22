package com.controller.command;

import java.io.Serializable;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@SuppressWarnings("serial")
@Component
public class LoginCommand implements Serializable {
	private String userName = null;
	private String password = null;
	
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
	
	public void validate(BindingResult results){
		if(userName == null || userName.trim().equals("")){
			results.rejectValue("userName", "username.req", "username is required");
		}
		
		if(password == null || password.trim().equals("")){
			results.rejectValue("password", "password.req", "password is required");
		}
	}

}
