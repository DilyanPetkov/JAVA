package com.theoryx.test.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.theoryx.test.model.User;

class UserMapper implements RowMapper<User> {

	public User mapRow(ResultSet rs, int arg1) throws SQLException {

		User user = new User();

		user.setId(rs.getInt("id"));
		
		user.setUsername(rs.getString("username"));

		user.setPassword(rs.getString("password"));

		user.setFirstname(rs.getString("firstname"));

		user.setLastname(rs.getString("lastname"));

		user.setEmail(rs.getString("email"));

		user.setAdress(rs.getString("adress"));

		user.setPhone(rs.getInt("phone"));

		return user;

	}

}
