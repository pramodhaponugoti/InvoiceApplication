package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.dao.bean.Project;

@Component
public class ProjectRowMapper implements RowMapper<Project> {

	@Override
	public Project mapRow(ResultSet rs, int indexNumber) throws SQLException {
		Project project = new Project();
		
		project.setProjectNumber(rs.getString(1));
		project.setClientNumber(rs.getString(2));
		project.setProjectName(rs.getString(3));
		project.setStartDate(rs.getString(4));
		project.setEndDate(rs.getString(5));
		project.setStatus(rs.getString(6));		
		project.setProjectManager(rs.getString(7));
		project.setClientContact(rs.getString(8));
		project.setBudget(rs.getString(9));
		project.setIsActive(rs.getBoolean(10));	
			
		return project;
	}	

}
