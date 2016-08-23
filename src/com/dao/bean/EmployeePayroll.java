package com.dao.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class EmployeePayroll implements Serializable {
	  private String projectNumber = null;
      private String  projectName= null;
      private String empName = null;
      private String billRate = null;      
      private String noOfHours = null;
      private String amountPaid = null;
      
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
	public String getNoOfHours() {
		return noOfHours;
	}
	public void setNoOfHours(String noOfHours) {
		this.noOfHours = noOfHours;
	}
	public String getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(String amountPaid) {
		this.amountPaid = amountPaid;
	}

	
      
        
}
