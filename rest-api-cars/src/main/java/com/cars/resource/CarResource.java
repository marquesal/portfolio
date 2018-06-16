package com.cars.resource;

import com.cars.exceptions.CarsException;
import com.cars.exceptions.ValidateException;
import com.cars.model.Cars;
import com.cars.service.CarsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/v1/api")
public class CarResource {

	@Autowired
	private CarsService carService;

	@RequestMapping(value = "/cars", method = RequestMethod.GET)
	public ResponseEntity<List<Map<String, Object>>> listAllCars() {

		try {
			List<Map<String, Object>> result = carService.listAllCars();
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (IllegalStateException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@RequestMapping(value = "/cars/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cars> getMuscleCar(@PathVariable("id") int id) {

		try {
			Cars car = carService.getCar(id);
			if (car != null) {
				return ResponseEntity.status(HttpStatus.OK).body(car);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}

		} catch (ValidateException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}

	@RequestMapping(value = "/cars/delete/{id}", method = {RequestMethod.GET,RequestMethod.DELETE})
	public String deleteMuscleCar(@PathVariable("id") int id) {

		try {
			carService.removeCarFromList(id);
			return  String.valueOf(ResponseEntity.status(HttpStatus.OK));
		} catch (ValidateException e) {
			return String.valueOf(ResponseEntity.status(HttpStatus.BAD_REQUEST));
		}

	}

	@RequestMapping(value = "/cars/add", method = RequestMethod.POST)
	public ResponseEntity<Void> addCarToList( @RequestBody Cars car) {

		try {
			carService.addCarToList(car);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (CarsException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@RequestMapping(value = "/cars/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateCar(@PathVariable("id") int id, @RequestBody Cars car) {

		try {
			carService.updateCarFromList(id, car);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch(IllegalStateException e ) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

}
