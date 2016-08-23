package com.dao.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ProjectReport implements Serializable {
	  private String projectNumber = null;
      private String  projectName= null;
      private Integer noOfEmps = null;
      private Integer noOfClients = null;
      private String startDate = null;
      private String endDate = null;
      private String budget = null;
      
      private String status = null;
      private String clientName = null;
      
      
      
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
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
	
	public Integer getNoOfEmps() {
		return noOfEmps;
	}
	public void setNoOfEmps(Integer noOfEmps) {
		this.noOfEmps = noOfEmps;
	}
	public Integer getNoOfClients() {
		return noOfClients;
	}
	public void setNoOfClients(Integer noOfClients) {
		this.noOfClients = noOfClients;
	}
	public String getBudget() {
		return budget;
	}
	public void setBudget(String budget) {
		this.budget = budget;
	}
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
      
      
   
        
}
