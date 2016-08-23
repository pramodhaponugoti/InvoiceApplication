package com.controller.command;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TimeSheetCommand implements Serializable {

	
	 private String personId;
     private String personName;
     private int    numberOfHours;
     private String loginDate;
    
     private String projectData;
    
     
     private String status="Approval is Pending...";

     
  

    public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	

	public String getProjectData() {
		return projectData;
	}

	public void setProjectData(String projectData) {
		this.projectData = projectData;
	}

	public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getNumberOfHours() {
        return numberOfHours;
    }

    public void setNumberOfHours(int numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    public String getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(String loginDate) {
        this.loginDate = loginDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
     
          
        
}
