package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.dao.bean.ProjectPerson;

@Component
public class ProjectPersonRowMapper implements RowMapper<ProjectPerson> {

	@Override
	public ProjectPerson mapRow(ResultSet rs, int indexNumber) throws SQLException {
		ProjectPerson projectPerson = new ProjectPerson();
		
		projectPerson.setProjectNumber(rs.getString(1));
		projectPerson.setPersonName(rs.getString(2));
		projectPerson.setIsActive(rs.getBoolean(3));	
			
		return projectPerson;
	}	

}	
