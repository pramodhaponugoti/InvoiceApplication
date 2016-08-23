package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.dao.bean.Invoice;
import com.dao.bean.InvoiceEmployee;
import com.dao.bean.TestData;
import com.exp.DataSourceException;

@Repository	
public class InvoiceDAO {

	@Autowired
	JdbcTemplate jdbcTemplate = null;
	
	@Autowired
	InvoiceRowMapper invoiceRowMapper = null;
	
	@Autowired
	TestDataRowMapper testDataRowMapper = null;
	
	@Autowired
	InvoiceEmployeeRowMapper invoiceEmployeeRowMapper = null;
	
	private List<Double> billRateList = new ArrayList<Double>();	
	
	public Invoice getClientDetails(String clientNumber , String projectNumber)  throws DataSourceException
	{
		Invoice invoice = null;
		String sql = "Select c.ClientNumber , p.ProjectName,c.AddressLine1,c.AddressLine2,c.City,c.State,c.zip, c.BillingTerms Payment_Terms,c.InvoiceFreq Billing_Freq,c.Name From Client c, Project p Where c.ClientNumber = p.ClientNumber And c.ClientNumber=? and p.ProjectNumber=?";
		try{
			invoice = jdbcTemplate.queryForObject(sql,new Object[]{
			clientNumber,
			projectNumber
			},invoiceRowMapper);
	
		}catch(Exception exp){
			exp.printStackTrace();
			throw new DataSourceException();
		}
		return invoice;
	}
	
	public List<InvoiceEmployee> getEmployeeDetails(String clientNumber , String projectNumber,String startDate,String endDate)  throws DataSourceException
	{
		List<InvoiceEmployee> emplList = null;
		String sql = "Select ts.personName,sum(ts.NumberOfHours) , e.BillRate , e.BillRate*sum(ts.NumberOfHours)  From  Project p,TimeSheet ts,Employee e Where ts.ProjectName = p.ProjectName and e.name= ts.PersonName and p.ClientNumber=? and ts.projectNo= ? and trunc(ts.Login_Date ) between trunc(to_date(?,'mm/dd/yyyy')) and trunc(to_date(?,'mm/dd/yyyy')) Group By ts.personName,e.BillRate";
		try{
			emplList = jdbcTemplate.query(sql,new Object[]{
			clientNumber,
			projectNumber,
			startDate,
			endDate
			},invoiceEmployeeRowMapper);
	
			for(InvoiceEmployee emp : emplList){
				billRateList.add(Double.valueOf(emp.getBillRate()));
			}
		}catch(Exception exp){
			exp.printStackTrace();
			throw new DataSourceException();
		}
		return emplList;
	}
	
	
	public List<String> getClientIds()  throws DataSourceException
	{
		List<String> clientIdList = null;
		 String sql = " Select DISTINCT c.ClientNumber From Client c , Project p Where c.ClientNumber = p.ClientNumber";
		try{
			clientIdList = jdbcTemplate.query(sql,new RowMapper<String>()
					{

						@Override
						public String mapRow(ResultSet rs, int index)
								throws SQLException {
							
							return rs.getString(1);
						}
				
					});
	
			
		}catch(Exception exp){
			exp.printStackTrace();
			throw new DataSourceException();
		}
		return clientIdList;
	}
	
	
	public List<String> getProjectIds()  throws DataSourceException
	{
		List<String> projectIdList = null;
		String sql = "Select DISTINCT P.ProjectNumber From Client c , Project p Where c.ClientNumber = p.ClientNumber ";
		try{
			projectIdList = jdbcTemplate.query(sql,new RowMapper<String>()
					{

						@Override
						public String mapRow(ResultSet rs, int index)
								throws SQLException {							
							return rs.getString(1);
						}
				
					});
	
			
		}catch(Exception exp){
			exp.printStackTrace();
			throw new DataSourceException();
		}
		return projectIdList;
	}
	
	public List<String> getProjectIds(String clientNumber)  throws DataSourceException
	{
		List<String> projectIdList = null;
		String sql = "Select DISTINCT P.ProjectNumber From Client c , Project p Where c.ClientNumber = p.ClientNumber  "
				+ "and c.ClientNumber = ?";
		try{
			
			projectIdList = jdbcTemplate.query(sql,new Object[]{clientNumber},new RowMapper<String>()
					{

						@Override
						public String mapRow(ResultSet rs, int index)
								throws SQLException {							
							return rs.getString(1);
						}
				
					});
	
			
		}catch(Exception exp){
			exp.printStackTrace();
			throw new DataSourceException();
		}
		return projectIdList;
	}
	

	public List<Double> getBillRateList() {
		return billRateList;
	}

	public void setBillRateList(List<Double> billRateList) {
		this.billRateList = billRateList;
	}
	
	
	public List<TestData> getTestData()  throws DataSourceException
	{
		List<TestData> testDataList = null;
		 String sql = " Select c.ClientNumber,p.ProjectName ,count(DISTINCT ts.personName) NoOfEmployees,sum(ts.NumberOfHours) NumberOfHours,p.Budget,p.StartDate,p.EndDate ,p.Status From Client c, Project p,TimeSheet ts,Employee e Where ts.ProjectNo = p.ProjectNumber and e.name= ts.PersonName and c.ClientNumber = p.ClientNumber Group By c.ClientNumber ,p.ProjectName ,p.Budget,p.StartDate,p.EndDate ,p.Status";
		try{
			testDataList = jdbcTemplate.query(sql, testDataRowMapper);
			
		}catch(Exception exp){
			exp.printStackTrace();
			throw new DataSourceException();
		}
		return testDataList;
	}
	
	
}
