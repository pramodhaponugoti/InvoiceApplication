package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.dao.bean.TestData;

@Component
public class TestDataRowMapper implements RowMapper<TestData> {

	@Override
	public TestData	 mapRow(ResultSet rs, int indexNumber) throws SQLException {
		
		TestData testData = new TestData();		
		testData.setClientID(rs.getString(1));
		testData.setClientName(rs.getString(2));	
		testData.setProjectNumber(rs.getString(3));
		testData.setProjectName(rs.getString(4));
		testData.setStartDate(rs.getString(5));
		testData.setEndDate(rs.getString(6));
		testData.setProjectBudget(rs.getString(7));
		testData.setNoOfEmps(rs.getString(8));
		testData.setNoOfHours(rs.getString(9));
		testData.setAmountPaid(rs.getString(10));
		testData.setProjectBeginDate(rs.getString(11));
		testData.setProjectEndDate(rs.getString(12));
		testData.setProjectBalance(rs.getString(13));
		testData.setProjectStatus(rs.getString(14));
		return testData;
	}	

}
