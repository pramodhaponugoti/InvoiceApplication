package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dao.bean.Employee;
import com.exp.DataSourceException;

@Repository	
public class EmployeeDAO {

	@Autowired
	JdbcTemplate jdbcTemplate = null;
	
	@Autowired
	EmployeeRowMapper rowMapper = null;
	
	public boolean addEmployee(Employee employee) throws DataSourceException
	{
		boolean flag = false;
		String sql = "Insert Into Employee Values(?,?,?,?,?)";
		try{
	jdbcTemplate.update(sql,
			employee.getName(),
			employee.getTitle(),
			employee.getBillRate(),
			employee.getRole(),
			employee.getIsActive());
	flag = true;
		}catch(Exception exp){
			exp.printStackTrace();
			throw new DataSourceException();
		}
		return flag;
	}
	
	public Employee updateEmployee(Employee employee) throws DataSourceException
	{
		
		String sql = "Update Employee set TITLE = ? , BILLRATE = ? , ROLE = ?"
                + " , ISACTIVE = ? Where NAME = ?";
		try{
	jdbcTemplate.update(sql,			
			employee.getTitle(),
			employee.getBillRate(),
			employee.getRole(),
			employee.getIsActive(),
			employee.getName());
		}catch(Exception exp){
			exp.printStackTrace();
			throw new DataSourceException();
		}
		return employee;
	}	
	
	public boolean updateEmployeeStatus( String name ) throws DataSourceException{
		boolean flag = false;
		String sql = "Update Employee set ISACTIVE = 0  Where Name = ?";
		try{
		jdbcTemplate.update(sql,name);
		flag = true;
		}catch(Exception exp){
			exp.printStackTrace();
			throw new DataSourceException();
		}
		return flag;
	}
	
	public boolean isEmployeeExist(String name ) throws DataSourceException{
		boolean flag = false;
		String sql = "Select * From Employee Where Name = ?";
		try{
		Employee employee = jdbcTemplate.queryForObject(sql,new Object[]{name},rowMapper);
		if(employee != null){
			flag = true;
		}
		}catch(EmptyResultDataAccessException exp){
			flag = false;	
		}
		catch(Exception exp){
			exp.printStackTrace();
			throw new DataSourceException();
		}
		return flag;
	}
	
	public List<Employee> getAllEmps() throws DataSourceException{
		List<Employee> employeeList = null;
		String sql = "Select * From Employee";
		try{
			employeeList = jdbcTemplate.query(sql,rowMapper);		
		}catch(Exception exp){
			exp.printStackTrace();
			throw new DataSourceException();
		}
		return employeeList;
	}
	
	public Employee getEmployeeByName(String name ) throws DataSourceException{
		Employee employee = null;
		String sql = "Select * From Employee Where Name = ?";
		try{
		 employee = jdbcTemplate.queryForObject(sql,new Object[]{name},rowMapper);
		
		}catch(EmptyResultDataAccessException exp){
			employee = null;	
		}
		catch(Exception exp){
			exp.printStackTrace();
			employee = null;
		}
		return employee;
	}
}
