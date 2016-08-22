package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dao.bean.TimeSheet;
import com.exp.DataSourceException;

@Repository
public class TimeSheetDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate = null;
	
	@Autowired
	TimeSheetMapper rowMapper = null;
	
	public boolean saveTimeSheet(TimeSheet timeSheet) throws DataSourceException
	{
		boolean flag = false;
		String sql = "Insert Into TimeSheet Values(?,?,?,?)";
		try{
			jdbcTemplate.update(sql,
			timeSheet.getPersonName(),
			timeSheet.getNumberOfHours(),
			timeSheet.getLoginDate(),
			timeSheet.getStatus());
	flag = true;
		}catch(Exception exp){
			exp.printStackTrace();
			throw new DataSourceException();
		}
		return flag;
	}
	
	public boolean updateTimeSheet(TimeSheet timeSheet)  throws DataSourceException
	{
		
		String sql = "Update TimeSheet set NumberOfHours = ?  Where PersonName = ? and Login_Date = ?";
		try{
	jdbcTemplate.update(sql,			
			timeSheet.getNumberOfHours(),
			timeSheet.getPersonName(),			
			timeSheet.getLoginDate());
		}catch(Exception exp){
			exp.printStackTrace();
			throw new DataSourceException();
		}
		return true;
	}	
	
	public boolean updateTimeSheetStatus(TimeSheet timeSheet) throws DataSourceException{
		boolean flag = false;
		String sql = "Update TimeSheet set Status = ?  Where PersonName = ? and Login_Date = ?";
		try{
		jdbcTemplate.update(sql, 
				timeSheet.getStatus(),
				timeSheet.getPersonName(),
				timeSheet.getLoginDate());
		flag = true;
		}catch(Exception exp){
			exp.printStackTrace();
			throw new DataSourceException();
		}
		return flag;
	}
	
	public boolean isTimeSheetExist(TimeSheet timeSheet) throws DataSourceException{
		boolean flag = false;
		String sql = "Select * From TimeSheet Where PersonName = ? and Login_Date = ?";
		try{
		TimeSheet tSheet = jdbcTemplate.queryForObject(sql,new Object[]{timeSheet.getPersonName(),timeSheet.getLoginDate()},rowMapper);
		if(tSheet != null){
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
	
	public List<TimeSheet> getTimeSheets() throws DataSourceException {
		List<TimeSheet> timeSheetList = null;
		String sql = "Select * From TimeSheet ";
		try {
			timeSheetList = jdbcTemplate.query(sql, rowMapper);
		} catch (Exception exp) {
			exp.printStackTrace();
			throw new DataSourceException();
		}
		return timeSheetList;
	}
	
	public List<TimeSheet> getTimeSheets(String personName) throws DataSourceException {
		List<TimeSheet> timeSheetList = null;
		String sql = "Select * From TimeSheet Where upper(PersonName) like ?  ";
		try {
			timeSheetList = jdbcTemplate.query(sql,new Object[]{"%"+personName.toUpperCase()+"%"}, rowMapper);
		} catch (Exception exp) {
			exp.printStackTrace();
			throw new DataSourceException();
		}
		return timeSheetList;
	}
	
	public TimeSheet getTimeSheet(String personName , String loginDate) throws DataSourceException{
		TimeSheet timeSheet = null;
		String sql = "Select * From TimeSheet Where PersonName = ? and Login_Date = ?";
		try{
		timeSheet = jdbcTemplate.queryForObject(sql,new Object[]{personName,loginDate},rowMapper);
		
		}catch(EmptyResultDataAccessException exp){
			timeSheet = null;	
		}
		catch(Exception exp){
			exp.printStackTrace();
			throw new DataSourceException();
		}
		return timeSheet;
	}
}
