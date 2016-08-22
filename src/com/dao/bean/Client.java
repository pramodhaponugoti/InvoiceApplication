package com.dao.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Client implements Serializable{
	private String clientNumber = null;
	private String name = null;
	private String addressLine1 = null;
	private String addressLine2 = null;
	private String city = null;
	private String state = null;
	private String zip = null;
	private String email = null;
	private String contact = null;
	private String invoiceFreq = null;
	private String billingTerms = null;
	private String invoiceGrouping = null;
	private Boolean isActive = true;
	public String getClientNumber() {
		return clientNumber;
	}
	public void setClientNumber(String clientNumber) {
		this.clientNumber = clientNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getInvoiceFreq() {
		return invoiceFreq;
	}
	public void setInvoiceFreq(String invoiceFreq) {
		this.invoiceFreq = invoiceFreq;
	}
	public String getBillingTerms() {
		return billingTerms;
	}
	public void setBillingTerms(String billingTerms) {
		this.billingTerms = billingTerms;
	}
	public String getInvoiceGrouping() {
		return invoiceGrouping;
	}
	public void setInvoiceGrouping(String invoiceGrouping) {
		this.invoiceGrouping = invoiceGrouping;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}	
	

}
