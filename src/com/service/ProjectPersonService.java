package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.ProjectPersonDAO;
import com.dao.bean.ProjectPerson;
import com.exp.DataSourceException;
import com.exp.ServicessException;

@Repository
public class ProjectPersonService {	

		
	@Autowired
	ProjectPersonDAO projectPersonDAO = null;
	
	public boolean addProjectPerson(ProjectPerson projectPerson) throws ServicessException
	{
		boolean flag = false;
		try{
			if(!projectPersonDAO.isProjectPersonExist(projectPerson)){
				projectPersonDAO.addProjectPerson(projectPerson);			
				flag = true;
			}
		}catch(DataSourceException exp){
			exp.printStackTrace();
			throw new ServicessException();
		}
		return flag;
	}
	
	public ProjectPerson updateProjectPerson(ProjectPerson projectPerson) throws ServicessException
	{
		
		try{			
				projectPersonDAO.updateProjectPerrson(projectPerson);	
		}catch(DataSourceException exp){
			exp.printStackTrace();
			throw new ServicessException();
		}
		return projectPerson;
	}	
	
	public boolean updateProjectPersonStatus(ProjectPerson projectPerson ) throws ServicessException{
		boolean flag = true;
		try{
			 projectPersonDAO.updateProjectPerrsonStatus(projectPerson);
		}catch(DataSourceException exp){
			exp.printStackTrace();
			throw new ServicessException();
		}
		return flag;
	}
	
	public boolean isProjectPersonExist(ProjectPerson projectPerson ) throws ServicessException{
		boolean flag = false;
		try{
			 flag = projectPersonDAO.isProjectPersonExist(projectPerson);
		}catch(DataSourceException exp){
			exp.printStackTrace();
			throw new ServicessException();
		}
		return flag;
	}
	
	public List<ProjectPerson> getAllProjectPersons() throws ServicessException{
		List<ProjectPerson> projectPersonList = null;
		try{
			projectPersonList = projectPersonDAO.getAllProjectPersons();
		}catch(DataSourceException exp){
			exp.printStackTrace();
			throw new ServicessException();
		}
		return projectPersonList;
	}
	
	public ProjectPerson getProjectPersonByNumber(ProjectPerson projectPerson) throws ServicessException{
		ProjectPerson project = null;
		try{
			project = projectPersonDAO.getProjectPersonByNumber(projectPerson);	
		}catch(DataSourceException exp){
			exp.printStackTrace();
			throw new ServicessException();
		}
		return project;
	}
}
