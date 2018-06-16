package com.cars.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.cars.model.Cars;

import java.util.List;
import java.util.Map;


@Repository
public class CarsDaoImpl extends JdbcDaoSupport implements CarsDao {

	@Autowired
	public CarsDaoImpl(JdbcTemplate jdbcTemplate, DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		setJdbcTemplate(jdbcTemplate);
	}

	@Override
	public Cars getCarFromList(int id) {
		String sql = "select * from cars where id = ?";
		Object[] args = new Object[] { id };
		return getJdbcTemplate().queryForObject(sql, args, new CarsRowMapper());
	}

	@Override
	public void removeCarFromList(int id) {
		String sql = "delete from cars where id = ?";
		Object[] args = new Object[] { id };
		getJdbcTemplate().update(sql, args);
	}

    @Override
    public void addCarToList(Cars car) {
        String sql = "insert into cars (car_brand, car_model, horsepower, car_engine, fk_users) values (?, ?, ?, ?, ?)";
        Object[] args = new Object[] {car.getCarBrand(), car.getCarModel(), car.getHorsepower(), car.getCarEngine(), car.getOwner()};
        getJdbcTemplate().update(sql, args);
    }

    @Override
    public void updateCarFromList(int id, Cars car) {
        String sql = "update cars set car_brand = ?, car_model = ?, horsepower = ?, car_engine = ?, fk_users = ?, where id = ?";
        Object[] args = new Object[] {car.getCarBrand(), car.getCarModel(), car.getHorsepower(), car.getCarEngine(), car.getOwner(), id};
        getJdbcTemplate().update(sql, args);
    }

    @Override
    public List<Map<String, Object>> listAllCars() {
        String sql = "select * from cars";
        return getJdbcTemplate().queryForList(sql);
    }

}
