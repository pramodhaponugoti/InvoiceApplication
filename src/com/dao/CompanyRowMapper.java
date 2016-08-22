package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.dao.bean.Company;

@Component
public class CompanyRowMapper implements RowMapper<Company> {

	@Override
	public Company mapRow(ResultSet rs, int indexNumber) throws SQLException {
		
		Company company = new Company();
		
		company.setName(rs.getString(1));
		company.setAddressLine1(rs.getString(2));
		company.setAddressLine2(rs.getString(3));
		company.setCity(rs.getString(4));
		company.setState(rs.getString(5));
		company.setZip(rs.getString(6));
		company.setIsActive(rs.getBoolean(7));
		
		return company;
	}	

}
