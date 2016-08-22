package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDAO;
import com.exp.DataSourceException;
import com.exp.ServicessException;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO = null;

	public String getRoleByUserLogin(String userName, String password)
			throws ServicessException {
		String role = null;
		try {
			role = userDAO.getRoleByUserLogin(userName, password);
		} catch (DataSourceException exp) {
			exp.printStackTrace();
			throw new ServicessException();
		}
		return role;
	}

	public void saveLoginRole(String role, String name)
			throws ServicessException {

		try {
			userDAO.saveLoginRole(role, name);
		} catch (DataSourceException exp) {
			exp.printStackTrace();
			throw new ServicessException();
		}

	}

	public String getLoginRole() throws ServicessException {
		String role = null;
		try {
			role = userDAO.getLoginRole();
		} catch (DataSourceException exp) {
			exp.printStackTrace();
			throw new ServicessException();
		}
		return role;
	}

	public String getLoginName() throws ServicessException {
		String name = null;
		try {
			name = userDAO.getLoginName();
		} catch (DataSourceException exp) {
			exp.printStackTrace();
			throw new ServicessException();
		}
		return name;
	}

}
