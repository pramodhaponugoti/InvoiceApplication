package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ClientDAO;
import com.dao.bean.Client;
import com.exp.DataSourceException;
import com.exp.ServicessException;

@Service
public class ClientService {

	@Autowired
	private	ClientDAO clientDAO = null;
	
	public boolean addClient(Client client) throws ServicessException
	{
		boolean flag = false;
		try{
			if(!clientDAO.isClientExist(client.getClientNumber())){
				clientDAO.addClient(client);				
				flag = true;
			}
		}catch(DataSourceException exp){
			exp.printStackTrace();
			throw new ServicessException();
		}
		return flag;
	}
	
	public Client updateClient(Client client) throws ServicessException
	{
		
		try{
			clientDAO.updateClient(client);				
				
		}catch(DataSourceException exp){
			exp.printStackTrace();
			throw new ServicessException();
		}
		return client;
	}
	
	public boolean updateClientStatus( String clientNumber) throws ServicessException
	{
		boolean flag = false;
		try{			
			flag =	clientDAO.updateClientStatus( clientNumber);
			}catch(DataSourceException exp){
			exp.printStackTrace();
			throw new ServicessException();
		}
		return flag;
	}
	
	public Client getClientByNumber(String clientNumber) throws ServicessException
	{
		Client client = null;
		try{
			client = clientDAO.getClientByNumber(clientNumber);
		}catch(DataSourceException exp){
			exp.printStackTrace();
			throw new ServicessException();
		}
		return client;
	}
	
	public List<Client> getAllClients() throws ServicessException{
		List<Client> clientList = null;
		try{
			clientList = clientDAO.getAllClients();
		}catch(DataSourceException exp){
			exp.printStackTrace();
			throw new ServicessException();
		}
		return clientList;
	}
	
	public boolean isClientExist( String clientNumber) throws ServicessException
	{
		boolean flag = false;
		try{			
			flag =	clientDAO.isClientExist(clientNumber);
			}catch(DataSourceException exp){
			exp.printStackTrace();
			throw new ServicessException();
		}
		return flag;
	}
}
