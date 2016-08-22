package com.controller.command;

import java.io.Serializable;

@SuppressWarnings("serial")
public class InvoiceCommand implements Serializable{

private String filePath ;
private String emailId;

public String getFilePath() {
	return filePath;
}
public void setFilePath(String filePath) {
	this.filePath = filePath;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}




}
