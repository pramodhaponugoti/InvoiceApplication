package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.CompanyDAO;
import com.dao.bean.Company;
import com.exp.DataSourceException;
import com.exp.ServicessException;

@Repository
public class CompanyService {

	@Autowired
	CompanyDAO companyDAO = null;	
	
	
	public boolean addCompany(Company company) throws ServicessException
	{
		boolean flag = false;
		try{
			if(!companyDAO.isComapnyExist(company.getName())){
				companyDAO.addCompany(company);				
				flag = true;
			}
		}catch(DataSourceException exp){
			exp.printStackTrace();
			throw new ServicessException();
		}
		return flag;
	}
	
	public Company updateCompany(Company company) throws ServicessException
	{
		
		try{
			companyDAO.updateCompany(company);
		}catch(DataSourceException exp){
			exp.printStackTrace();
			throw new ServicessException();
		}
		
		return company;
	}	
	
	public boolean updateCompanyStatus(String name ) throws ServicessException{
		boolean flag = false;
		try{
			
			flag = companyDAO.updateCompanyStatus( name);				
				
		}catch(DataSourceException exp){
			exp.printStackTrace();
			throw new ServicessException();
		}
		return flag;
	}
	
	public boolean isComapnyExist(String name ) throws ServicessException{
		boolean flag = false;
		try{
			
			flag = companyDAO.isComapnyExist(name);				
				
		}catch(DataSourceException exp){
			exp.printStackTrace();
			throw new ServicessException();
		}
		return flag;
	}
	
	
	public Company getComapnyByName(String name ) throws ServicessException{
		Company company = null;
		try {

			company = companyDAO.getComapnyByName(name);

		} catch (DataSourceException exp) {
			exp.printStackTrace();
			throw new ServicessException();
		}
		return company;
	}
	
	public List<Company> getAllCompanies() throws ServicessException{
		List<Company> companyList = null;
		try {

			companyList = companyDAO.getAllCompanies();

		} catch (DataSourceException exp) {
			exp.printStackTrace();
			throw new ServicessException();
		}
		return companyList;
	}
}
