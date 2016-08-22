package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dao.bean.Project;
import com.exp.DataSourceException;

@Repository
public class ProjectDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate = null;
	
	@Autowired
	ProjectRowMapper rowMapper = null;
	
	public boolean addProject(Project project) throws DataSourceException
	{
		boolean flag = false;
		String sql = "Insert Into Project Values(?,?,?,?,?,?,?,?,?,?)";
		try{
	jdbcTemplate.update(sql,
			project.getProjectNumber(),
			project.getClientNumber(),
			project.getProjectName(),
			project.getStartDate(),
			project.getEndDate(),
			project.getStatus(),
			project.getProjectManager(),
			project.getClientContact(),
			project.getBudget(),
			project.getIsActive()
			);
	flag = true;
		}catch(Exception exp){
			exp.printStackTrace();
			throw new DataSourceException();
		}
		return flag;
	}
	
	public Project updateProject(Project project) throws DataSourceException
	{
		
		String sql = "Update Project set CLIENTNUMBER = ? , PROJECTNAME = ? , STARTDATE = ? , ENDDATE = ?"
                + " , STATUS = ? ,PROJECTMANAGER = ? , CLIENTCONTACT = ? , "
                + " BUDGET = ?  ,ISACTIVE = ? Where PROJECTNUMBER = ?";
		try{
	jdbcTemplate.update(sql,
			project.getClientNumber(),
			project.getProjectName(),
			project.getStartDate(),
			project.getEndDate(),
			project.getStatus(),
			project.getProjectManager(),
			project.getClientContact(),
			project.getBudget(),
			project.getIsActive(),
			project.getProjectNumber()
			);
		}catch(Exception exp){
			exp.printStackTrace();
			throw new DataSourceException();
		}
		return project;
	}	
	
	public boolean updateProjectStatus(String projectNumber ) throws DataSourceException{
		boolean flag = false;
		String sql = "Update Project set ISACTIVE = 0 Where PROJECTNUMBER = ?";
		try{
		jdbcTemplate.update(sql, projectNumber);
		flag = true;
		}catch(Exception exp){
			exp.printStackTrace();
			throw new DataSourceException();
		}
		return flag;
	}
	
	public boolean isProjectExist(String  projectNumber) throws DataSourceException{
		boolean flag = false;
		String sql = "Select * From Project Where PROJECTNUMBER = ?";
		try{
		Project project = jdbcTemplate.queryForObject(sql,new Object[]{projectNumber},rowMapper);
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
	
	public Project getProjectByNumber(String projectNumber ) throws DataSourceException{
		Project project = null;
		String sql = "Select * From Project Where PROJECTNUMBER = ?";
		try{
		project = jdbcTemplate.queryForObject(sql,new Object[]{projectNumber},rowMapper);
		
		}catch(EmptyResultDataAccessException exp){
			project = null;
		}
		catch(Exception exp){
			exp.printStackTrace();
			project = null;
		}
		return project;
	}
	
	public List<Project> getAllProjects() throws DataSourceException{
		List<Project> projectList = null;
		String sql = "Select * From Project";
		try{
			projectList = jdbcTemplate.query(sql,rowMapper);		
		}catch(Exception exp){
			exp.printStackTrace();
			throw new DataSourceException();
		}
		return projectList;
	}
}
