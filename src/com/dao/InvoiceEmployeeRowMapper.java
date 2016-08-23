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
		invoiceEmployee.setEmpName(rs.getString(1));	
		invoiceEmployee.setNoOfHours(rs.getInt(2));
		invoiceEmployee.setBillRate(rs.getString(3));
		invoiceEmployee.setSumBillRate(rs.getString(4));
		
		return invoiceEmployee;
	}	

}
