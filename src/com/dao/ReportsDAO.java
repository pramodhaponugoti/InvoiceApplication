package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.dao.bean.EmployeePayroll;
import com.dao.bean.Invoice;
import com.dao.bean.InvoiceEmployee;
import com.dao.bean.ProjectReport;
import com.exp.DataSourceException;

@Repository
public class ReportsDAO {

	@Autowired
	JdbcTemplate jdbcTemplate = null;
	
		
	public List<Invoice> getClientDataForInvoiceReport() throws DataSourceException{
		List<Invoice> invoiceClientList = null;
		String sql = "Select c.ClientNumber ,c.Name ClientName,p.ProjectNumber, p.ProjectName,"
				+ "c.AddressLine1,c.AddressLine2,c.City,c.State,c.zip, c.BillingTerms Payment_Terms,c.InvoiceFreq Billing_Freq From Client c, Project p Where c.ClientNumber = p.ClientNumber ORDER BY c.ClientNumber ASC";
		try{
			invoiceClientList = jdbcTemplate.query(sql,new RowMapper<Invoice>(){

			@Override
			public Invoice mapRow(ResultSet rs, int index) throws SQLException {
				// TODO Auto-generated method stub
				Invoice invoice = new Invoice();
				invoice.setClientNumber(rs.getString(1));
				invoice.setClientName(rs.getString(2));
				invoice.setProjectNumber(rs.getString(3));
				invoice.setProject(rs.getString(4));
				invoice.setAddressLine1(rs.getString(5));
				invoice.setAddressLine2(rs.getString(6));
				invoice.setCity(rs.getString(7));
				invoice.setState(rs.getString(8));
				invoice.setZip(rs.getString(9));
				invoice.setPaymentTerms(rs.getString(10));
				invoice.setBillingFreq(rs.getString(11));				
				return invoice;
			}
			
		});
		
		}
		catch(Exception exp){
			exp.printStackTrace();
			throw new DataSourceException(exp.getMessage());
		}
		return invoiceClientList;
	}
	
	public List<InvoiceEmployee> getEmployeeDataForInvoiceReport() throws DataSourceException{
		List<InvoiceEmployee> invoiceEmplList = null;
		String sql = "Select p.ProjectNumber, p.ProjectName,e.Name EmployeeName,c.ClientNumber ,p.StartDate,p.EndDate,e.BillRate From Client c, Project p,ProjectPerson pp,Employee e Where c.ClientNumber = p.ClientNumber And pp.ProjectNumber = p.ProjectNumber and e.name= pp.PersonName ORDER BY c.ClientNumber ASC";
		try{
			invoiceEmplList = jdbcTemplate.query(sql,new RowMapper<InvoiceEmployee>()
					{

						@Override
						public InvoiceEmployee mapRow(ResultSet rs, int index)
								throws SQLException {
							// TODO Auto-generated method stub
							InvoiceEmployee invoiceEmployee = new InvoiceEmployee();
							invoiceEmployee.setProjectNumber(rs.getString(1));
							invoiceEmployee.setProjectName(rs.getString(2));
							invoiceEmployee.setEmpName(rs.getString(3));
							invoiceEmployee.setClientNumber(rs.getString(4));
							invoiceEmployee.setStartDate(rs.getString(5));
							invoiceEmployee.setEndDate(rs.getString(6));
							invoiceEmployee.setBillRate(rs.getString(7));
							
							return invoiceEmployee;
						}
				
					});		
		}catch(Exception exp){
			exp.printStackTrace();
			throw new DataSourceException();
		}
		return invoiceEmplList;
	}
	
	public List<EmployeePayroll> getEmployeePayrollReports() throws DataSourceException{
		List<EmployeePayroll>  emplPayrollList = null;
		String sql = "Select  e.Name ,p.ProjectNumber ,p.ProjectName,e.BillRate ,e.BillRate*8 BillRate_Per_Day , e.BillRate*40 BillRate_Per_Week , e.BillRate*40*8 BillRate_Per_Month From Project p,ProjectPerson pp,Employee e Where pp.ProjectNumber = p.ProjectNumber and e.name=pp.PersonName  Order By  p.ProjectNumber ASC";
		try{
			emplPayrollList = jdbcTemplate.query(sql,new RowMapper<EmployeePayroll>()
					{

						@Override
						public EmployeePayroll mapRow(ResultSet rs, int index)
								throws SQLException {
							// TODO Auto-generated method stub
							EmployeePayroll empPayroll = new EmployeePayroll();
							empPayroll.setEmpName(rs.getString(1));
							empPayroll.setProjectNumber(rs.getString(2));
							empPayroll.setProjectName(rs.getString(3));
							empPayroll.setBillRate(rs.getString(4));
							empPayroll.setBillRatePerDay(rs.getString(5));
							empPayroll.setBillRatePerWeek(rs.getString(6));
							empPayroll.setBillRatePerMonth(rs.getString(7));
							
							return empPayroll;
						}
				
					});		
		}catch(Exception exp){
			exp.printStackTrace();
			throw new DataSourceException();
		}
		return emplPayrollList;
	}
	
	
	public List<ProjectReport> getProjectReports() throws DataSourceException{
		List<ProjectReport> projectReportList = null;
		String sql = "Select p.ProjectNumber ,p.ProjectName,count(DISTINCT e.Name) NumberOfEmps,count(DISTINCT c.ClientNumber) NumberOfClient, p.StartDate,p.EndDate,p.Budget From Client c ,Project p,ProjectPerson pp,Employee e Where c.ClientNumber = p.ClientNumber and pp.ProjectNumber = p.ProjectNumber and e.name=pp.PersonName Group By p.ProjectNumber ,p.ProjectName, p.StartDate,p.EndDate,p.Budget Order By  p.ProjectNumber ASC";
		try{
			projectReportList = jdbcTemplate.query(sql,new RowMapper<ProjectReport>()
					{

						@Override
						public ProjectReport mapRow(ResultSet rs, int index)
								throws SQLException {
							// TODO Auto-generated method stub
							ProjectReport projectReport = new ProjectReport();
							projectReport.setProjectNumber(rs.getString(1));
							projectReport.setProjectName(rs.getString(2));
							projectReport.setNoOfEmps(rs.getInt(3));
							projectReport.setNoOfClients(rs.getInt(4));
							projectReport.setStartDate(rs.getString(5));
							projectReport.setEndDate(rs.getString(6));
							projectReport.setBudget(rs.getString(7));
							
							return projectReport;
						}
				
					});		
		}catch(Exception exp){
			exp.printStackTrace();
			throw new DataSourceException();
		}
		return projectReportList;
	}
}
