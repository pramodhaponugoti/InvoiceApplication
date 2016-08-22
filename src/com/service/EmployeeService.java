package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.dao.EmployeeDAO;
import com.dao.bean.Employee;
import com.exp.DataSourceException;
import com.exp.ServicessException;

@Repository
public class EmployeeService {

		
	@Autowired
	EmployeeDAO employeeDAO = null;
	
	public boolean addEmployee(Employee employee) throws ServicessException
	{
		boolean flag = false;
		try{
			if(!employeeDAO.isEmployeeExist(employee.getName())){
				employeeDAO.addEmployee(employee);				
				flag = true;
			}
		}catch(DataSourceException exp){
			exp.printStackTrace();
			throw new ServicessException();
		}
		return flag;
	}
	
	public Employee updateEmployee(Employee employee) throws ServicessException
	{
		
		try{			
				employeeDAO.updateEmployee(employee);	
		}catch(DataSourceException exp){
			exp.printStackTrace();
			throw new ServicessException();
		}
		return employee;
	}	
	
	public boolean updateEmployeeStatus(String name ) throws ServicessException{
		boolean flag = false;
		try{
			flag = employeeDAO.updateEmployeeStatus(name);
		}catch(DataSourceException exp){
			exp.printStackTrace();
			throw new ServicessException();
		}
		return flag;
	}
	
	public boolean isEmployeeExist(String name ) throws ServicessException{
		boolean flag = false;
		try{
			 flag = employeeDAO.isEmployeeExist(name);
		}catch(DataSourceException exp){
			exp.printStackTrace();
			throw new ServicessException();
		}
		return flag;
	}
	
	public List<Employee> getAllEmps() throws ServicessException{
		List<Employee> employeeList = null;
		try{
			employeeList = employeeDAO.getAllEmps();
		}catch(DataSourceException exp){
			exp.printStackTrace();
			throw new ServicessException();
		}
		return employeeList;
	}
	
	public Employee getEmployeeByName(String name ) throws ServicessException{
		Employee employee = null;
		try{
			employee = employeeDAO.getEmployeeByName(name);
		}catch(DataSourceException exp){
			exp.printStackTrace();
			throw new ServicessException();
		}
		return employee;
	}
}
