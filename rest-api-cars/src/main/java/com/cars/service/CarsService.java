package com.cars.service;

import com.cars.dao.CarsDao;
import com.cars.exceptions.CarsException;
import com.cars.exceptions.ValidateException;
import com.cars.model.Cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class CarsService {

	@Autowired
	private CarsDao carDao;

	public Cars getCar(int id) throws ValidateException {
		if (id <= 0) {
			throw new ValidateException("ID can not be 0 or <0");
		}
		return carDao.getCarFromList(id);
	}

	public void removeCarFromList(int id) throws ValidateException {
		if (id <= 0) {
			throw new ValidateException("ID can not be 0 or < 0 or this id do not exist");
		}
		 carDao.removeCarFromList(id);
	}

	public List<Map<String, Object>> listAllCars() {

		List<Map<String, Object>> result = carDao.listAllCars();
			if (!result.isEmpty()) {
				return result;
			} else {
				return null;
			}
	}

	public void addCarToList(Cars car) throws CarsException {
		if (car == null) {
			throw new CarsException("The passed object can not be null.");
		}
		carDao.addCarToList(car);
	}

	public void updateCarFromList(int id, Cars car) {
		if ( id <= 0 && car == null) {
			throw new IllegalArgumentException("The passed object can not be null.");
		}
		carDao.updateCarFromList(id, car);
	}

}
