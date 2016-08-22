package com.dao.bean;

import java.io.Serializable;
import java.sql.Timestamp;

@SuppressWarnings("serial")
public class Invoice implements Serializable {
    
        private String addressLine1 = null;
        private String addressLine2 = null;
        private String city = null;
        private String state = null;
        private String zip = null;
        private String clientNumber = null;
        private String project = null;
        private String invoiceDate = null;
        private String paymentTerms = null;
        private String billingFreq = null;
        private String totalAmountDue = null;
        
        private String clientName = null;
        private String projectNumber = null;
        
        
        public Invoice(){
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
           String[] dateTime = timestamp.toString().split(" ");
           String date  = dateTime[0];
           String[] d = date.split("-");
           invoiceDate = d[2]+"/"+d[1]+"/"+d[0];
           // System.out.println("**** timestamp ***** "+dateTime[0]);
            //System.out.println("**** invoiceDate ***** "+invoiceDate);
           
        }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(String clientNumber) {
        this.clientNumber = clientNumber;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public String getBillingFreq() {
        return billingFreq;
    }

    public void setBillingFreq(String billingFreq) {
        this.billingFreq = billingFreq;
    }

    public String getTotalAmountDue() {
        return totalAmountDue;
    }

    public void setTotalAmountDue(String totalAmountDue) {
        this.totalAmountDue = totalAmountDue;
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

	

	public static void main(String args[]) {
		new Invoice();
	}
        
        
}
