package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.dao.bean.TimeSheet;

@Component
public class TimeSheetMapper implements RowMapper<TimeSheet> {
	
	@Override
	public TimeSheet mapRow(ResultSet rs, int indexNumber) throws SQLException {
		TimeSheet timeSheet = new TimeSheet();
		
		timeSheet.setPersonId(rs.getString(1));
		timeSheet.setPersonName(rs.getString(2));
		timeSheet.setNumberOfHours(rs.getInt(3));
		timeSheet.setProjectNo(rs.getString(4));
		timeSheet.setProjectName(rs.getString(5));
		
		String finalDate = null;
		String msg =rs.getString(6);
		String[] test = msg.split("-");
		
		if(test.length > 1){
		String month[] = test[2].split(" ");
		System.out.println(test[1]+"/"+month[0]+"/"+test[0]);
		 finalDate = test[1]+"/"+month[0]+"/"+test[0];
		}else{
			finalDate = rs.getString(6);
		}
		System.out.println(finalDate);
/*
		Timestamp timestamp = Timestamp.valueOf(dateFrom[0]);
        String[] dateTime = timestamp.toString().split(" ");
        String date  = dateTime[0];
        String[] d = date.split("-");
        String reqDate = d[1]+"/"+d[2]+"/"+d[0];*/	
		timeSheet.setLoginDate(finalDate);
		timeSheet.setStatus(rs.getString(7));			
		return timeSheet;
	}	
	
	

}
