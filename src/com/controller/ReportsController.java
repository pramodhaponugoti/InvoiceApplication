package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.service.ReportsService;
	
@Controller
public class ReportsController {	
	
	
	@Autowired
	private ReportsService reportsService = null;
	
	
	@RequestMapping(value="/invoiceReports",method=RequestMethod.GET)
	public String loadInvoiceReports(ModelMap modelMap) throws Exception{
			
		modelMap.addAttribute("clientDataList",reportsService.getClientDataForInvoiceReport());
		modelMap.addAttribute("employeeDataList",reportsService.getEmployeeDataForInvoiceReport());
		modelMap.addAttribute("clientMsg","Clients Information...!");
		modelMap.addAttribute("empMsg","Employees Information...!");
	  		
		return "invoicereportsdata";
	}
	
	@RequestMapping(value="/payrollReports",method=RequestMethod.GET)
	public String loadPayrollReports(ModelMap modelMap) throws Exception{
			
		modelMap.addAttribute("payrollDataList",reportsService.getEmployeePayrollReports());
		modelMap.addAttribute("payrollMsg","Employee Payroll Information...!");
		  		
		return "payrollreportsdata";
	}
	
	@RequestMapping(value="/projectReports",method=RequestMethod.GET)
	public String loadProjectReports(ModelMap modelMap) throws Exception{
			
		modelMap.addAttribute("projectDataList",reportsService.getProjectReports());
		modelMap.addAttribute("projectMsg","Project Information...!");
		  		
		return "projectreportsdata";
	}
	
	
	

}
