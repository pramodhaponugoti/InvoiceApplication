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
		testData.setProjectName(rs.getString(2));
		testData.setNoOfEmps(rs.getString(3));
		testData.setNoOfHours(rs.getString(4));
		testData.setProjectBudget(rs.getString(5));
		testData.setStartDate(rs.getString(6));
		testData.setEndDate(rs.getString(7));
		testData.setProjectStatus(rs.getString(8));
		return testData;
	}	

}
