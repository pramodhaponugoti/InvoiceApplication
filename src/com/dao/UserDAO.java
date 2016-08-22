package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.exp.DataSourceException;

@Repository
public class UserDAO {

	@Autowired
	JdbcTemplate jdbcTemplate = null;

	public String getRoleByUserLogin(String userName, String password)
			throws DataSourceException {
		String role = null;
		String sql = "Select Role From Users Where LoginID = ? AND PASSWORD = ?";
		try {
			role = jdbcTemplate.queryForObject(sql, new Object[] { userName,
					password }, String.class);

		} catch (EmptyResultDataAccessException exp) {
			role = null;
		} catch (Exception exp) {
			exp.printStackTrace();
			throw new DataSourceException();
		}
		return role;
	}

	public void saveLoginRole(String role, String name)
			throws DataSourceException {

		String sql = "update LoginRole set Role = ? ,name=?";
		try {
			jdbcTemplate.update(sql, role, name);

		} catch (Exception exp) {
			exp.printStackTrace();
			throw new DataSourceException();
		}

	}

	public String getLoginRole() throws DataSourceException {
		String role = null;
		String sql = "Select Role From LoginRole";
		try {
			role = jdbcTemplate.queryForObject(sql, String.class);

		} catch (EmptyResultDataAccessException exp) {
			role = null;
		} catch (Exception exp) {
			exp.printStackTrace();
			throw new DataSourceException();
		}
		return role;
	}

	public String getLoginName() throws DataSourceException {

		String name = null;
		String sql = "Select Name From LoginRole";
		try {
			name = jdbcTemplate.queryForObject(sql, String.class);

		} catch (EmptyResultDataAccessException exp) {
			name = null;
		} catch (Exception exp) {
			exp.printStackTrace();
			throw new DataSourceException();
		}
		return name;
	}

}
