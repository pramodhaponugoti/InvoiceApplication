package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.dao.bean.TimeSheet;
import com.exp.DataSourceException;

@Repository
public class TimeSheetDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate = null;
	
	@Autowired
	TimeSheetMapper rowMapper = null;
	
	@Autowired
	UserDAO userDAO = null;
	
	public boolean saveTimeSheet(TimeSheet timeSheet) throws DataSourceException
	{
		boolean flag = false;
		String sql = "Insert Into TimeSheet Values(?,?,?,?,?,TO_Date(?,'MM/DD/YYYY'),?)";
		try{
			jdbcTemplate.update(sql,
			timeSheet.getPersonId(),
			timeSheet.getPersonName(),
			timeSheet.getNumberOfHours(),
			timeSheet.getPersonId(),
			timeSheet.getProjectName(),
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
		
		String sql = "Update TimeSheet set NumberOfHours = ?,ProjectName=?   Where PersonName = ? and Login_Date =  TO_Date(?,'MM/DD/YYYY')";
		try{
	jdbcTemplate.update(sql,			
			timeSheet.getNumberOfHours(),
			timeSheet.getProjectName(),
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
		
		String sql = "Update TimeSheet set Status = ?  Where PersonName = ? and  Login_Date = TO_Date('"+timeSheet.getLoginDate()+"','MM/DD/YYYY')";
		try{
			System.out.println("timeSheet : "+timeSheet.getLoginDate());
			System.out.println("sql : "+sql);
		jdbcTemplate.update(sql, 
				timeSheet.getStatus(),
				timeSheet.getPersonName()
				);
		flag = true;
		}catch(Exception exp){
			exp.printStackTrace();
			throw new DataSourceException();
		}
		return flag;
	}
	
	public boolean isTimeSheetExist(TimeSheet timeSheet) throws DataSourceException{
		boolean flag = false;
		String sql = "Select * From TimeSheet Where PersonName = ? and  Login_Date =  TO_Date(?,'MM/DD/YYYY')";
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
		String sql = "";
		try {
			
			if(userDAO.getLoginRole().equals("Developer"))
			{
				sql = "Select PersonId,PersonName,NumberOfHours,Projectno,ProjectName,TO_CHAR(Login_Date, 'MM/DD/YYYY'),Status From TimeSheet where upper(PersonName) like ? ";
			timeSheetList = jdbcTemplate.query(sql, new Object[]{userDAO.getLoginName().toUpperCase()},rowMapper);
			}else
			{
				sql =   "Select PersonId,PersonName,NumberOfHours,Projectno,ProjectName,TO_CHAR(Login_Date, 'MM/DD/YYYY'),Status From TimeSheet ";
				timeSheetList = jdbcTemplate.query(sql, rowMapper);
			}
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
		String sql = "Select * From TimeSheet Where PersonName = ? and Login_Date = TO_Date(?,'MM/DD/YYYY')";
		try{
			System.out.println("loginDate : "+loginDate);
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
	
	public List<String> getProjectNameId(String sql) throws DataSourceException{
		List<String> pnameIdList = new ArrayList<String>();
		try{
		System.out.println("SQL "+sql);
		jdbcTemplate.query(sql,new RowMapper<String>(){

			@Override
			public String mapRow(ResultSet rs, int index) throws SQLException {
				// TODO Auto-generated method stub
				pnameIdList.add(rs.getString(1)+"-"+rs.getString(2));
				return "TEST";
			}
			
		});
		
		}
		catch(Exception exp){
			exp.printStackTrace();
			throw new DataSourceException();
		}
		return pnameIdList;
	}
}
