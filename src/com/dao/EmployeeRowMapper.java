package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.dao.bean.Employee;

@Component
public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int indexNumber) throws SQLException {
		
		Employee employee = new Employee();
		
		employee.setName(rs.getString(1));
		employee.setTitle(rs.getString(2));
		employee.setBillRate(rs.getString(3));
		employee.setRole(rs.getString(4));
		employee.setIsActive(rs.getBoolean(5));
		
		
		return employee;
	}	

}
