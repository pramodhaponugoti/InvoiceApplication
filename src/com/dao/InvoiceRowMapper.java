package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.dao.bean.Invoice;

@Component	
public class InvoiceRowMapper implements RowMapper<Invoice> {

	@Override
	public Invoice mapRow(ResultSet rs, int indexNumber) throws SQLException {
		
		Invoice invoice = new Invoice();
		invoice.setClientNumber(rs.getString(1));
		invoice.setProject(rs.getString(2));
		invoice.setAddressLine1(rs.getString(3));
		invoice.setAddressLine2(rs.getString(4));
		invoice.setCity(rs.getString(5));
		invoice.setState(rs.getString(6));
		invoice.setZip(rs.getString(7));
		invoice.setPaymentTerms(rs.getString(8));
		invoice.setBillingFreq(rs.getString(9));
		invoice.setClientName(rs.getString(10));
		
		return invoice;
	}	

}
