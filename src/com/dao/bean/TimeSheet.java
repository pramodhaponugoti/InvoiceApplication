package com.dao.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TimeSheet implements Serializable {

     private String personName;
     private int    numberOfHours;
     private String loginDate;
     private String status="Approval is Pending...";

  

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
