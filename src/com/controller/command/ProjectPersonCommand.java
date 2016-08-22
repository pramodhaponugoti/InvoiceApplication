package com.controller.command;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ProjectPersonCommand implements Serializable {

       
	private String projectNumber = null;
	private String personName = null;
    	private Boolean isActive = true;
	
    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
       

   
        
}
