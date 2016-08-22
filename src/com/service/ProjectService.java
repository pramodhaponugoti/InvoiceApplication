package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.ProjectDAO;
import com.dao.bean.Project;
import com.exp.DataSourceException;
import com.exp.ServicessException;

@Repository
public class ProjectService {	

		
	@Autowired
	ProjectDAO projectDAO = null;
	
	public boolean addProject(Project project) throws ServicessException
	{
		boolean flag = false;
		try{
			if(!projectDAO.isProjectExist(project.getProjectNumber())){
				projectDAO.addProject(project);			
				flag = true;
			}
		}catch(DataSourceException exp){
			exp.printStackTrace();
			throw new ServicessException();
		}
		return flag;
	}
	
	public Project updateProject(Project project) throws ServicessException
	{
		
		try{			
				projectDAO.updateProject(project);	
		}catch(DataSourceException exp){
			exp.printStackTrace();
			throw new ServicessException();
		}
		return project;
	}	
	
	public boolean updateProjectStatus(String projectNumber ) throws ServicessException{
		boolean flag = false;
		try{
			flag = projectDAO.updateProjectStatus(projectNumber);
		}catch(DataSourceException exp){
			exp.printStackTrace();
			throw new ServicessException();
		}
		return flag;
	}
	
	public boolean isProjectExist(String projectNumber ) throws ServicessException{
		boolean flag = false;
		try{
			 flag = projectDAO.isProjectExist(projectNumber);
		}catch(DataSourceException exp){
			exp.printStackTrace();
			throw new ServicessException();
		}
		return flag;
	}
	
	public List<Project> getAllProjects() throws ServicessException{
		List<Project> projectList = null;
		try{
			projectList = projectDAO.getAllProjects();
		}catch(DataSourceException exp){
			exp.printStackTrace();
			throw new ServicessException();
		}
		return projectList;
	}
	
	public Project getProjectByNumber(String projectNumber) throws ServicessException{
		Project project = null;
		try{
			project = projectDAO.getProjectByNumber(projectNumber);
		}catch(DataSourceException exp){
			exp.printStackTrace();
			throw new ServicessException();
		}
		return project;
	}
}
