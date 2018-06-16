package com.cars.dao;

import org.springframework.jdbc.core.RowMapper;

import com.cars.model.Cars;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CarsRowMapper implements RowMapper<Cars> {

	@Override
	public Cars mapRow(ResultSet rs, int arg1) throws SQLException {
		Cars mc = new Cars();
		mc.setId(rs.getInt("id"));
		mc.setCarBrand(rs.getString("car_brand"));
		mc.setCarModel(rs.getString("car_model"));
		mc.setCarEngine(rs.getString("car_engine"));
		mc.setHorsepower(rs.getInt("horsepower"));
		return mc;
	}

}
