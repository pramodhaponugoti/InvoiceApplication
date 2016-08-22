package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.dao.bean.Client;

@Component
public class ClientRowMapper implements RowMapper<Client> {

	@Override
	public Client mapRow(ResultSet rs, int indexNumber) throws SQLException {
		Client client = new Client();
		
		client.setClientNumber(rs.getString(1));
		client.setName(rs.getString(2));
		client.setAddressLine1(rs.getString(3));
		client.setAddressLine2(rs.getString(4));
		client.setCity(rs.getString(5));
		client.setState(rs.getString(6));
		client.setZip(rs.getString(7));
		client.setEmail(rs.getString(8));
		client.setContact(rs.getString(9));
		client.setInvoiceFreq(rs.getString(10));
		client.setBillingTerms(rs.getString(11));
		client.setInvoiceGrouping(rs.getString(12));
		client.setIsActive(rs.getBoolean(13));
			
		return client;
	}	

}
