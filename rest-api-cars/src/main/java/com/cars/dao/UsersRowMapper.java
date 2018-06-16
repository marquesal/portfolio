package com.cars.dao;

import org.springframework.jdbc.core.RowMapper;

import com.cars.model.Users;

import java.sql.ResultSet;
import java.sql.SQLException;


public class UsersRowMapper implements RowMapper<Users> {

	@Override
	public Users mapRow(ResultSet rs, int arg1) throws SQLException {
		Users user = new Users();
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setAge(rs.getInt("age"));
		user.setAddress(rs.getString("address"));
		return user;
	}

}
