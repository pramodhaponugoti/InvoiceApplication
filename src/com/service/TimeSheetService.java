package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.TimeSheetDAO;
import com.dao.bean.TimeSheet;
import com.exp.DataSourceException;
import com.exp.ServicessException;

@Repository
public class TimeSheetService {

	@Autowired
	TimeSheetDAO timeSheetDAO = null;	
	
	
	public boolean saveTimeSheet(TimeSheet timeSheet) throws ServicessException
	{
		boolean flag = false;
		try{
			flag = timeSheetDAO.saveTimeSheet(timeSheet);
		}catch(DataSourceException exp){
			exp.printStackTrace();
			throw new ServicessException();
		}
		return flag;
	}
	
	public boolean updateTimeSheet(TimeSheet timeSheet) throws ServicessException
	{
		boolean flag = false;
		
		try{
			flag = timeSheetDAO.updateTimeSheet(timeSheet);
		}catch(DataSourceException exp){
			exp.printStackTrace();
			throw new ServicessException();
		}
		
		return flag;
	}	
	
	public boolean updateTimeSheetStatus(TimeSheet timeSheet) throws ServicessException{
		boolean flag = false;
		try{
			
			flag = timeSheetDAO.updateTimeSheetStatus(timeSheet);		
				
		}catch(DataSourceException exp){
			exp.printStackTrace();
			throw new ServicessException();
		}	
		return flag;
	}
	
	public boolean isTimeSheetExist(TimeSheet timeSheet) throws ServicessException{
		boolean flag = false;
		try{
			
			flag =timeSheetDAO.isTimeSheetExist(timeSheet);				
				
		}catch(DataSourceException exp){
			exp.printStackTrace();
			throw new ServicessException();
		}
		return flag;
	}
	
	public List<TimeSheet> getTimeSheets() throws ServicessException{
		List<TimeSheet> timeSheetList = null;
		try{
			
			timeSheetList =timeSheetDAO.getTimeSheets();				
				
		}catch(DataSourceException exp){
			exp.printStackTrace();
			throw new ServicessException();
		}
		return timeSheetList;
	}
	
	public List<TimeSheet> getTimeSheets(String personName) throws ServicessException{
		List<TimeSheet> timeSheetList = null;
		try{
			
			timeSheetList =timeSheetDAO.getTimeSheets(personName);				
				
		}catch(DataSourceException exp){
			exp.printStackTrace();
			throw new ServicessException();
		}
		return timeSheetList;
	}
	
	public TimeSheet getTimeSheet(String personName , String loginDate) throws ServicessException{
		TimeSheet timeSheet = null;
		try{
			
			timeSheet =timeSheetDAO.getTimeSheet(personName,loginDate);				
				
		}catch(DataSourceException exp){
			exp.printStackTrace();
			throw new ServicessException();
		}
		return timeSheet;
	}
	
	public List<String> getProjectNameId(String sql) throws ServicessException{
		List<String> pnameIdList = null;
		try{
			
			pnameIdList =timeSheetDAO.getProjectNameId(sql);				
				
		}catch(DataSourceException exp){
			exp.printStackTrace();
			throw new ServicessException();
		}
		return pnameIdList;
	}
	
	
	
}
