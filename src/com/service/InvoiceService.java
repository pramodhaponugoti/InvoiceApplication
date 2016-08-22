package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.InvoiceDAO;
import com.dao.bean.Invoice;
import com.dao.bean.InvoiceEmployee;
import com.dao.bean.TestData;
import com.exp.DataSourceException;
import com.exp.ServicessException;

@Service
public class InvoiceService {
	
	@Autowired
	private	InvoiceDAO invoiceDAO = null;
	
	public Invoice getClientDetails(String clientNumber , String projectNumber)  throws ServicessException
	{
		Invoice invoice = null;
		try{
			invoice = invoiceDAO.getClientDetails(clientNumber, projectNumber);
		}catch(DataSourceException exp){
			/*exp.printStackTrace();
			throw new ServicessException();*/
		}
		return invoice;
	}
	
	public List<InvoiceEmployee> getEmployeeDetails(String clientNumber , String projectNumber)  throws ServicessException
	{
		List<InvoiceEmployee> emplList = null;
		try{
			emplList = invoiceDAO.getEmployeeDetails(clientNumber, projectNumber);
		}catch(DataSourceException exp){
			exp.printStackTrace();
			throw new ServicessException();
		}
		return emplList;
	}
	
	
	public List<String> getClientIds()  throws ServicessException
	{
		List<String> clientIdsList = null;
		try{
			clientIdsList = invoiceDAO.getClientIds();
		}catch(DataSourceException exp){
			exp.printStackTrace();
			throw new ServicessException();
		}
		return clientIdsList;
	}
	
	public List<String> getProjectIds()  throws ServicessException
	{
		List<String> projectIdsList = null;
		try{
			projectIdsList = invoiceDAO.getProjectIds();
		}catch(DataSourceException exp){
			exp.printStackTrace();
			throw new ServicessException();
		}
		return projectIdsList;
	}
	
	public List<String> getProjectIds(String clientNumber)  throws ServicessException
	{
		List<String> projectIdsList = null;
		try{
			projectIdsList = invoiceDAO.getProjectIds(clientNumber);
		}catch(DataSourceException exp){
			exp.printStackTrace();
			throw new ServicessException();
		}
		return projectIdsList;
	}
	
	
	
	public List<Double> getBillRateList() {
		return invoiceDAO.getBillRateList();
	}
	
	public List<TestData> getTestData()  throws ServicessException
	{
		List<TestData> testDataList = null;
		try{
			testDataList = invoiceDAO.getTestData();
		}catch(DataSourceException exp){
			/*exp.printStackTrace();
			throw new ServicessException();*/
		}
		return testDataList;
	}
}
