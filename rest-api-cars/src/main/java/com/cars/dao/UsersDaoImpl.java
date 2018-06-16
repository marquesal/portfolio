package com.cars.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.cars.model.Users;

import java.util.List;
import java.util.Map;


@Repository
public class UsersDaoImpl extends JdbcDaoSupport implements UsersDao {

	@Autowired
	public UsersDaoImpl(JdbcTemplate jdbcTemplate, DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		setJdbcTemplate(jdbcTemplate);
	}

	@Override
	public Users getUserFromList(int id) {
		String sql = "select * from users where id = ?";
		Object[] args = new Object[] { id };
		return getJdbcTemplate().queryForObject(sql, args, new UsersRowMapper());
	}

	@Override
	public void removeUserFromList(int id) {
		String sql = "delete from users where id = ?";
		Object[] args = new Object[] { id };
		getJdbcTemplate().update(sql, args);
	}

    @Override
    public void addUserToList(Users user) {
        String sql = "insert into users (name, age, address) values (?, ?, ?)";
        Object[] args = new Object[] {user.getName(), user.getAge(), user.getAddress()};
        getJdbcTemplate().update(sql, args);
    }

	@Override
	public void updateUserFromList(int id, Users user) {
        String sql = "update users set name = ?, age = ?, address = ?, where id = ?";
        Object[] args = new Object[] {user.getName(), user.getAge(), user.getAddress(), id};
        getJdbcTemplate().update(sql, args);		
	}

	@Override
	public List<Map<String, Object>> listAllUsers() {
		String sql = "select * from users";
		return getJdbcTemplate().queryForList(sql);
	}

	@Override
	public List<Map<String, Object>> listUsersCars() {
		String sql = "select * from users inner join cars on users.id = cars.fk_users";
		return getJdbcTemplate().queryForList(sql);
	}

	@Override
	public List<Map<String, Object>> listOwnedCars(int id) {
		String sql = "select * from cars where cars.fk_users = ?";
		Object[] args = new Object[] {id};
		return getJdbcTemplate().queryForList(sql,args);
	}
}
