package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dao.bean.ProjectPerson;
import com.exp.DataSourceException;

@Repository
public class ProjectPersonDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate = null;
	
	@Autowired
	ProjectPersonRowMapper rowMapper = null;	
	
	public boolean addProjectPerson(ProjectPerson projectPerson) throws DataSourceException
	{
		boolean flag = false;
		String sql = "Insert Into ProjectPerson Values(?,?,?)";
		try{
	jdbcTemplate.update(sql,
			projectPerson.getProjectNumber(),
			projectPerson.getPersonName(),
			projectPerson.getIsActive()
			);
	flag = true;
		}catch(Exception exp){
			exp.printStackTrace();
			throw new DataSourceException();
		}
		return flag;
	}
	
	public ProjectPerson updateProjectPerrson(ProjectPerson projectPerson) throws DataSourceException
	{
		
		String sql = "Update ProjectPerson set ISACTIVE = ? Where PROJECTNUMBER = ? AND PERSONNAME=?";
		try{
	jdbcTemplate.update(sql,
			true,
			projectPerson.getProjectNumber(),
			projectPerson.getPersonName()			
			);
		}catch(Exception exp){
			exp.printStackTrace();
			throw new DataSourceException();
		}
		return projectPerson;
	}	
	
	public ProjectPerson updateProjectPerrsonStatus(ProjectPerson projectPerson) throws DataSourceException
	{
		
		String sql = "Update ProjectPerson set ISACTIVE = ? Where PROJECTNUMBER = ? AND PERSONNAME=?";
		try{
	jdbcTemplate.update(sql,
			false,
			projectPerson.getProjectNumber(),
			projectPerson.getPersonName()			
			);
		}catch(Exception exp){
			exp.printStackTrace();
			throw new DataSourceException();
		}
		return projectPerson;
	}	
	
	
	public boolean isProjectPersonExist(ProjectPerson projectPerson) throws DataSourceException{
		boolean flag = false;
		String sql = "Select * From ProjectPerson Where PROJECTNUMBER = ? AND PERSONNAME = ?";
		try{
		ProjectPerson project = jdbcTemplate.queryForObject(sql,new Object[]{projectPerson.getProjectNumber(),projectPerson.getPersonName()},rowMapper);
		if(project != null){
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
	
	public ProjectPerson getProjectPersonByNumber(ProjectPerson projectPerson ) throws DataSourceException{
		ProjectPerson project = null;
		String sql = "Select * From ProjectPerson Where PROJECTNUMBER = ? AND PERSONNAME = ?";
		try{
		project = jdbcTemplate.queryForObject(sql,new Object[]{projectPerson.getProjectNumber(),projectPerson.getPersonName()},rowMapper);
		
		}catch(EmptyResultDataAccessException exp){
			project = null;
		}
		catch(Exception exp){
			exp.printStackTrace();
			project = null;
		}
		return project;
	}
	
	public List<ProjectPerson> getAllProjectPersons() throws DataSourceException{
		List<ProjectPerson> projectPersonList = null;
		String sql = "Select * From ProjectPerson";
		try{
			projectPersonList = jdbcTemplate.query(sql,rowMapper);		
		}catch(Exception exp){
			exp.printStackTrace();
			throw new DataSourceException();
		}
		return projectPersonList;
	}
}
