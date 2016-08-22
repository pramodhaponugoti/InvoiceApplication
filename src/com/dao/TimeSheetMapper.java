package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.dao.bean.TimeSheet;

@Component
public class TimeSheetMapper implements RowMapper<TimeSheet> {
	
	@Override
	public TimeSheet mapRow(ResultSet rs, int indexNumber) throws SQLException {
		TimeSheet timeSheet = new TimeSheet();
		
		timeSheet.setPersonName(rs.getString(1));
		timeSheet.setNumberOfHours(rs.getInt(2));
		timeSheet.setLoginDate(rs.getString(3));
		timeSheet.setStatus(rs.getString(4));			
		return timeSheet;
	}	

}
