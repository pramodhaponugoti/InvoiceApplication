package com.dao.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class EmployeePayroll implements Serializable {
	  private String projectNumber = null;
      private String  projectName= null;
      private String empName = null;
      private String billRate = null;
      
      private String billRatePerDay = null;
      private String billRatePerWeek = null;
      private String billRatePerMonth = null;
      
      
    
	
	public String getProjectNumber() {
		return projectNumber;
	}
	public void setProjectNumber(String projectNumber) {
		this.projectNumber = projectNumber;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getBillRate() {
		return billRate;
	}
	public void setBillRate(String billRate) {
		this.billRate = billRate;
	}
	
	
	public String getBillRatePerDay() {
		return billRatePerDay;
	}
	public void setBillRatePerDay(String billRatePerDay) {
		this.billRatePerDay = billRatePerDay;
	}
	public String getBillRatePerWeek() {
		return billRatePerWeek;
	}
	public void setBillRatePerWeek(String billRatePerWeek) {
		this.billRatePerWeek = billRatePerWeek;
	}
	public String getBillRatePerMonth() {
		return billRatePerMonth;
	}
	public void setBillRatePerMonth(String billRatePerMonth) {
		this.billRatePerMonth = billRatePerMonth;
	}
	
      
        
}
