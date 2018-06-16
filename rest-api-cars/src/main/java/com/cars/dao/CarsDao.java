package com.cars.dao;


import java.util.List;
import java.util.Map;

import com.cars.model.Cars;

public interface CarsDao {

	Cars getCarFromList(int id);
	
	void removeCarFromList(int id);

	void addCarToList(Cars car);

	void updateCarFromList(int id, Cars car);

	List<Map<String, Object>> listAllCars();

}
