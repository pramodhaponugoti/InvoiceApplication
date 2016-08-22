package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.controller.command.LoginCommand;
import com.service.UserService;

@Controller
public class LoginController {	
		
	@Autowired
	private UserService userService = null;
	
	@Autowired
	private LoginCommand loginCommand = null;
	
	
	@RequestMapping(value="/loginPage",method=RequestMethod.GET)
	public String getLoginPage(ModelMap modelMap) throws Exception{
		
		modelMap.addAttribute("loginCommand", loginCommand);
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String doLogin(ModelMap modelMap,@ModelAttribute LoginCommand loginCommand,BindingResult results) throws Exception{
		modelMap.addAttribute("loginCommand", loginCommand);
		loginCommand.validate(results);
		if(results.hasErrors() ){
				return "login";
		}
		String role = userService.getRoleByUserLogin(loginCommand.getUserName(), loginCommand.getPassword());
		
		if(role != null){
		userService.saveLoginRole(role, loginCommand.getUserName());
		}
		
		if(role != null && role.equalsIgnoreCase("Developer")){
		return "empmainpage";
		}else if(role != null && role.equalsIgnoreCase("Project Manager")){
			return "mgrmainpage";
			}else if(role != null && role.equalsIgnoreCase("Accountant")){
				return "mainpage";
				}else{
			results.rejectValue("userName", "invalid.login", "invalid username or password");
			return "login";
		}
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(ModelMap modelMap) throws Exception{
		
		modelMap.addAttribute("loginCommand", loginCommand);
		return "login";
	}
	
	
}
