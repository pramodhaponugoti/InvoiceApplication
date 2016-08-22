package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ReportsDAO;
import com.dao.bean.EmployeePayroll;
import com.dao.bean.Invoice;
import com.dao.bean.InvoiceEmployee;
import com.dao.bean.ProjectReport;
import com.exp.DataSourceException;
import com.exp.ServicessException;

@Service
public class ReportsService {

	@Autowired
	private	ReportsDAO reportsDAO = null;
	
	public  List<Invoice> getClientDataForInvoiceReport()throws ServicessException
	{
		List<Invoice> invoiceClientList = null;
		try{
			invoiceClientList = reportsDAO.getClientDataForInvoiceReport();
		}catch(DataSourceException exp){
			exp.printStackTrace();
			throw new ServicessException();
		}
		return invoiceClientList;
	}
	
	public  List<InvoiceEmployee> getEmployeeDataForInvoiceReport() throws ServicessException
	{
		List<InvoiceEmployee> invoiceEmplList = null;
		try{
			invoiceEmplList = reportsDAO.getEmployeeDataForInvoiceReport();
		}catch(DataSourceException exp){
			exp.printStackTrace();
			throw new ServicessException();
		}
		return invoiceEmplList;
	}
	
	public   List<EmployeePayroll> getEmployeePayrollReports() throws ServicessException
	{
		List<EmployeePayroll> emplPayrollList = null;
		try{
			emplPayrollList = reportsDAO.getEmployeePayrollReports();
		}catch(DataSourceException exp){
			exp.printStackTrace();
			throw new ServicessException();
		}
		return emplPayrollList;
	}
	
	public  List<ProjectReport> getProjectReports() throws ServicessException
	{
		 List<ProjectReport> projectReportList = null;
		try{
			projectReportList = reportsDAO.getProjectReports();
		}catch(DataSourceException exp){
			exp.printStackTrace();
			throw new ServicessException();
		}
		return projectReportList;
	}
	
}
