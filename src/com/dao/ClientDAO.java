package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dao.bean.Client;
import com.exp.DataSourceException;

@Repository
public class ClientDAO {

	@Autowired
	JdbcTemplate jdbcTemplate = null;
	
	@Autowired
	ClientRowMapper rowMapper = null;
	
	public boolean addClient(Client client) throws DataSourceException
	{
		boolean flag = false;
		String sql = "Insert Into Client Values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try{
	jdbcTemplate.update(sql,
			client.getClientNumber(),
			client.getName(),
			client.getAddressLine1(),
			client.getAddressLine2(),
			client.getCity(),
			client.getState(),
			client.getZip(),
			client.getEmail(),
			client.getContact(),
			client.getInvoiceFreq(),
			client.getBillingTerms(),
			client.getInvoiceGrouping(),
			client.getIsActive());
	flag = true;
		}catch(Exception exp){
			exp.printStackTrace();
			throw new DataSourceException();
		}
		return flag;
	}
	
	public Client updateClient(Client client) throws DataSourceException
	{
		
		String sql = "Update Client set NAME = ? , ADDRESSLINE1 = ? , ADDRESSLINE2 = ? , CITY = ?"
                + " , STATE = ? ,ZIP = ? , EMAIL = ? , "
                + " CONTACT = ? ,INVOICEFREQ = ? , BILLINGTERMS = ? , INVOICEGROUPING = ? ,ISACTIVE = ? Where CLIENTNUMBER = ?";
		try{
	jdbcTemplate.update(sql,			
			client.getName(),
			client.getAddressLine1(),
			client.getAddressLine2(),
			client.getCity(),
			client.getState(),
			client.getZip(),
			client.getEmail(),
			client.getContact(),
			client.getInvoiceFreq(),
			client.getBillingTerms(),
			client.getInvoiceGrouping(),
			client.getIsActive(),
			client.getClientNumber());
		}catch(Exception exp){
			exp.printStackTrace();
			throw new DataSourceException();
		}
		return client;
	}	
	
	public boolean updateClientStatus(String clientNumber ) throws DataSourceException{
		boolean flag = false;
		String sql = "Update Client set ISACTIVE = 0 Where CLIENTNUMBER = ?";
		try{
		jdbcTemplate.update(sql, clientNumber);
		flag = true;
		}catch(Exception exp){
			exp.printStackTrace();
			throw new DataSourceException();
		}
		return flag;
	}
	
	public boolean isClientExist(String clientNumber ) throws DataSourceException{
		boolean flag = false;
		String sql = "Select * From Client Where CLIENTNUMBER = ?";
		try{
		Client client = jdbcTemplate.queryForObject(sql,new Object[]{clientNumber},rowMapper);
		if(client != null){
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
	
	public Client getClientByNumber(String clientNumber ) throws DataSourceException{
		Client client = null;
		String sql = "Select * From Client Where CLIENTNUMBER = ?";
		try{
		client = jdbcTemplate.queryForObject(sql,new Object[]{clientNumber},rowMapper);
		
		}catch(EmptyResultDataAccessException exp){
			client = null;
		}
		catch(Exception exp){
			exp.printStackTrace();
			client = null;
		}
		return client;
	}
	
	public List<Client> getAllClients() throws DataSourceException{
		List<Client> clientList = null;
		String sql = "Select * From Client";
		try{
			clientList = jdbcTemplate.query(sql,rowMapper);		
		}catch(Exception exp){
			exp.printStackTrace();
			throw new DataSourceException();
		}
		return clientList;
	}
}
