package com.dao.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TestData  implements Serializable{
	private String clientID ;
	private String clientName;
	private String projectNumber;
	private String projectName;
	private String startDate;
	private String endDate;
	private String projectBudget;
	private String noOfEmps;
	private String noOfHours;
	private String amountPaid;
	private String projectBeginDate;
	private String projectEndDate;
	private String projectBalance;
	private String projectStatus;
	public String getClientID() {
		return clientID;
	}
	public void setClientID(String clientID) {
		this.clientID = clientID;
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
	public String getProjectBudget() {
		return projectBudget;
	}
	public void setProjectBudget(String projectBudget) {
		this.projectBudget = projectBudget;
	}
	public String getNoOfEmps() {
		return noOfEmps;
	}
	public void setNoOfEmps(String noOfEmps) {
		this.noOfEmps = noOfEmps;
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
	public String getProjectBeginDate() {
		return projectBeginDate;
	}
	public void setProjectBeginDate(String projectBeginDate) {
		this.projectBeginDate = projectBeginDate;
	}
	public String getProjectEndDate() {
		return projectEndDate;
	}
	public void setProjectEndDate(String projectEndDate) {
		this.projectEndDate = projectEndDate;
	}
	public String getProjectBalance() {
		return projectBalance;
	}
	public void setProjectBalance(String projectBalance) {
		this.projectBalance = projectBalance;
	}
	public String getProjectStatus() {
		return projectStatus;
	}
	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}
	
	

}
