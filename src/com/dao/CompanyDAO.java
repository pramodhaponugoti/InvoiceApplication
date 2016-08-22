package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dao.bean.Company;
import com.exp.DataSourceException;

@Repository
public class CompanyDAO {

	@Autowired
	JdbcTemplate jdbcTemplate = null;
	
	@Autowired
	CompanyRowMapper rowMapper = null;
	
	public boolean addCompany(Company company) throws DataSourceException
	{
		boolean flag = false;
		String sql = "Insert Into Company Values(?,?,?,?,?,?,?)";
		try{
	jdbcTemplate.update(sql,
			company.getName(),
			company.getAddressLine1(),
			company.getAddressLine2(),
			company.getCity(),
			company.getState(),
			company.getZip(),
			company.getIsActive());
	flag = true;
		}catch(Exception exp){
			exp.printStackTrace();
			throw new DataSourceException();
		}
		return flag;
	}
	
	public Company updateCompany(Company company) throws DataSourceException
	{
		
		String sql = "Update Company set ADDRESSLINE1 = ? , ADDRESSLINE2 = ? , CITY = ?"
                + " , STATE = ? ,ZIP = ? ,ISACTIVE = ? Where NAME = ?";
		try{
	jdbcTemplate.update(sql,			
			company.getAddressLine1(),
			company.getAddressLine2(),
			company.getCity(),
			company.getState(),
			company.getZip(),
			company.getIsActive(),
			company.getName());
		}catch(Exception exp){
			exp.printStackTrace();
			throw new DataSourceException();
		}
		return company;
	}	
	
	public boolean updateCompanyStatus( String name ) throws DataSourceException{
		boolean flag = false;
		String sql = "Update Company set ISACTIVE = 0 Where Name = ?";
		try{
		jdbcTemplate.update(sql,name);
		flag = true;
		}catch(Exception exp){
			exp.printStackTrace();
			throw new DataSourceException();
		}
		return flag;
	}
	
	public boolean isComapnyExist(String name ) throws DataSourceException{
		boolean flag = false;
		String sql = "Select * From Company Where Name = ?";
		try{
		Company company = jdbcTemplate.queryForObject(sql,new Object[]{name},rowMapper);
		if(company != null){
			flag = true;
		}
		}catch(EmptyResultDataAccessException exp){
			flag = false;	
		}
		catch(Exception exp){
			exp.printStackTrace();
			throw new DataSourceException();
		}
		return flag;
	}
	
	
	public Company getComapnyByName(String name ) throws DataSourceException{
		Company company = null;
		String sql = "Select * From Company Where Name = ?";
		try{
		company = jdbcTemplate.queryForObject(sql,new Object[]{name},rowMapper);
		
		}catch(EmptyResultDataAccessException exp){
			company = null;
		}
		catch(Exception exp){
			exp.printStackTrace();
			company = null;
		}
		return company;
	}
	
	public List<Company> getAllCompanies() throws DataSourceException{
		List<Company> companyList = null;
		String sql = "Select * From Company";
		try{
			companyList = jdbcTemplate.query(sql,rowMapper);		
		}catch(Exception exp){
			exp.printStackTrace();
			throw new DataSourceException();
		}
		return companyList;
	}
}
