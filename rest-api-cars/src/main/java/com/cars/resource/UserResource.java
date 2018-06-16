package com.cars.resource;

import com.cars.exceptions.UsersException;
import com.cars.exceptions.ValidateException;
import com.cars.model.Users;
import com.cars.service.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/v1/api")
public class UserResource {

	@Autowired
	private UsersService userService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<Map<String, Object>>> listAllUsers() {

		try {
			List<Map<String, Object>> result = userService.listAllUsers();
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (IllegalStateException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@RequestMapping(value = "/users/cars", method = RequestMethod.GET)
	public ResponseEntity<List<Map<String, Object>>> listAllUsersCars() {
		
		try {
			List<Map<String, Object>> result = userService.listUsersCars();
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (IllegalStateException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@RequestMapping(value = "/users/cars/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<Map<String, Object>>> listOwnedCars(@PathVariable("id") int id) {
		
		try {
			List<Map<String, Object>> result = userService.listOwnedCars(id);
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (IllegalStateException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public ResponseEntity<Users> getUser(@PathVariable("id") int id) {

		try {
			Users user = userService.getUser(id);
			if (user != null) {
				return ResponseEntity.status(HttpStatus.OK).body(user);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}

		} catch (ValidateException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}

	@RequestMapping(value = "/users/delete/{id}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable("id") int id) {

		try {
			userService.removeUserFromList(id);
			return  String.valueOf(ResponseEntity.status(HttpStatus.OK));
		} catch (ValidateException e) {
			return String.valueOf(ResponseEntity.status(HttpStatus.BAD_REQUEST));
		}

	}

	@RequestMapping(value = "/users/add", method = RequestMethod.POST)
	public ResponseEntity<Void> addUserToList( @RequestBody Users user) {

		try {
			userService.addUserToList(user);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (UsersException e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@RequestMapping(value = "/users/update/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateUser(@PathVariable("id") int id, @RequestBody Users user) {

		try {
			userService.updateUserFromList(id, user);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch(IllegalStateException e ) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

}
