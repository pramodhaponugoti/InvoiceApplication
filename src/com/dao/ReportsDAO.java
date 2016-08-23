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
		String sql = "Select c.ClientNumber ,p.ProjectName ,c.BillingTerms Payment_Terms,c.InvoiceFreq Billing_Freq,ts.personName EmpName,sum(ts.NumberOfHours) NumberOfHours , e.BillRate , e.BillRate*sum(ts.NumberOfHours) AmountPaid  From Client c, Project p,TimeSheet ts,Employee e Where ts.ProjectName = p.ProjectName and e.name= ts.PersonName and c.ClientNumber = p.ClientNumber Group By c.ClientNumber ,p.ProjectName ,c.BillingTerms,c.InvoiceFreq,ts.personName,e.BillRate ORDER BY c.ClientNumber ASC";
		try{
			invoiceClientList = jdbcTemplate.query(sql,new RowMapper<Invoice>(){

			@Override
			public Invoice mapRow(ResultSet rs, int index) throws SQLException {
				// TODO Auto-generated method stub
				Invoice invoice = new Invoice();
				invoice.setClientNumber(rs.getString(1));
				invoice.setProject(rs.getString(2));
				invoice.setPaymentTerms(rs.getString(3));
				invoice.setBillingFreq(rs.getString(4));
				invoice.setEmpName(rs.getString(5));
				invoice.setNoOfHours(rs.getString(6));
				invoice.setBillRate(rs.getString(7));
				invoice.setAmountPaid(rs.getString(8));
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
		String sql = "Select ts.personName EmployeeName,p.ProjectNumber , p.projectName ,sum(ts.NumberOfHours) NumberOfHours, e.BillRate , e.BillRate*sum(ts.NumberOfHours)  AmountPaid From  Project p,TimeSheet ts,Employee e Where ts.ProjectNo = p.ProjectNumber and e.name= ts.PersonName  Group By p.ProjectNumber,ts.personName,p.projectName ,e.BillRate,p.Budget Order By p.ProjectNumber ASC";
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
							empPayroll.setNoOfHours(rs.getString(4));
							empPayroll.setBillRate(rs.getString(5));
							empPayroll.setAmountPaid(rs.getString(6));
							
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
		String sql = "Select p.ProjectNumber , p.projectName ,count(pp.PersonName) NumberOfEmployees, p.startDate,p.endDate ,p.Budget,p.Status,c.Name ClientName From  Project p,Client c ,ProjectPerson  pp Where pp.ProjectNumber = p.ProjectNumber and c.ClientNumber= p.ClientNumber  Group By p.projectName ,p.startDate,p.endDate ,p.Budget,c.Name,p.Status,p.ProjectNumber Order By  p.ProjectNumber ASC";
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
							projectReport.setStartDate(rs.getString(4));
							projectReport.setEndDate(rs.getString(5));
							projectReport.setBudget(rs.getString(6));
							projectReport.setStatus(rs.getString(7));
							projectReport.setClientName(rs.getString(8));
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
