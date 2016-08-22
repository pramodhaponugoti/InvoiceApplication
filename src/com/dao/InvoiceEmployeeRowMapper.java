package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.dao.bean.InvoiceEmployee;

@Component	
public class InvoiceEmployeeRowMapper implements RowMapper<InvoiceEmployee> {

	@Override
	public InvoiceEmployee mapRow(ResultSet rs, int indexNumber) throws SQLException {
		
		InvoiceEmployee invoiceEmployee = new InvoiceEmployee();
		invoiceEmployee.setStartDate(rs.getString(1));	
		invoiceEmployee.setEndDate(rs.getString(2));
		invoiceEmployee.setEmpName(rs.getString(3));
		invoiceEmployee.setBillRate(rs.getString(4));
		
		return invoiceEmployee;
	}	

}
