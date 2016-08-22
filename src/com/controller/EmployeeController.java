package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.controller.command.EmployeeCommand;
import com.dao.bean.Employee;
import com.service.EmployeeService;
import com.service.UserService;

@Controller
public class EmployeeController {		
		
	@Autowired
	private EmployeeService employeeService = null;
	
	@Autowired
	private UserService userService = null;
	
	
	
	@RequestMapping(value="/addEmployeeForm",method=RequestMethod.GET)
	public String addEmployeeForm(ModelMap modelMap) throws Exception{	
		modelMap.addAttribute("employeeCommand",new EmployeeCommand());
		modelMap.addAttribute("role", userService.getLoginRole());
		return "employee";		
		
	}	
	
	
	@RequestMapping(value="/employeeList",method=RequestMethod.GET)
	public String getEmployeeList(ModelMap modelMap) throws Exception{	
		modelMap.addAttribute("employeeDataList",employeeService.getAllEmps());
		modelMap.addAttribute("role", userService.getLoginRole());
		return "employeelist";		
		
	}
	
	@RequestMapping(value="/addEmployee",method=RequestMethod.POST)
	public String addEmployee(ModelMap modelMap,@ModelAttribute EmployeeCommand employeeCommand , BindingResult results) throws Exception{	

		Employee employee = new Employee();
		
		employee.setName(employeeCommand.getName());
		employee.setTitle(employeeCommand.getTitle());
		employee.setBillRate(employeeCommand.getBillRate());
		employee.setRole(employeeCommand.getRole());
		employee.setIsActive(employeeCommand.getIsActive());
		
		employeeService.addEmployee(employee);
		
		modelMap.addAttribute("resultMsg","Employee Registration is successfull...!");
		modelMap.addAttribute("employeeDataList",employeeService.getAllEmps());
		modelMap.addAttribute("role", userService.getLoginRole());
		return "employeelist";		
		
	}
	
	@RequestMapping(value="/editEmployee",method=RequestMethod.GET)
	public String editEmployee(ModelMap modelMap,@RequestParam("name") String name ) throws Exception{	

		Employee employee = employeeService.getEmployeeByName(name);
		EmployeeCommand employeeCommand = new EmployeeCommand();
		employeeCommand.setName(employee.getName());
		employeeCommand.setTitle(employee.getTitle());
		employeeCommand.setBillRate(employee.getBillRate());
		employeeCommand.setRole(employee.getRole());
		employeeCommand.setIsActive(employee.getIsActive());
		modelMap.addAttribute("employeeCommand", employeeCommand);
		
		modelMap.addAttribute("role", userService.getLoginRole());
		
		if(employee.getIsActive())
			return "editemployee";
		else
			return "readeditemployee";
			
		
	}
	
	@RequestMapping(value="/updateEmployee",method=RequestMethod.POST)
	public String updateEmployeeForm(ModelMap modelMap,@ModelAttribute EmployeeCommand employeeCommand , BindingResult results) throws Exception{	
		
		Employee employee = new Employee();
		
		employee.setName(employeeCommand.getName());
		employee.setTitle(employeeCommand.getTitle());
		employee.setBillRate(employeeCommand.getBillRate());
		employee.setRole(employeeCommand.getRole());
		employee.setIsActive(employeeCommand.getIsActive());
		
		employeeService.updateEmployee(employee);
		
		modelMap.addAttribute("resultMsg","Employee updation is successfull...!");
		modelMap.addAttribute("employeeDataList",employeeService.getAllEmps());
		modelMap.addAttribute("role", userService.getLoginRole());
		return "employeelist";		
		
	}
	
	@RequestMapping(value="/inactiveEmployee",method=RequestMethod.GET)
	public String inactiveEmployee(ModelMap modelMap,@RequestParam("name") String name) throws Exception{	
	
		employeeService.updateEmployeeStatus(name);
		
		modelMap.addAttribute("resultMsg","Employee is inactivated...!");
		modelMap.addAttribute("employeeDataList",employeeService.getAllEmps());
		modelMap.addAttribute("role", userService.getLoginRole());
		return "employeelist";	
		
	}
	
}
