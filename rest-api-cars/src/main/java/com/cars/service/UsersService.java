package com.cars.service;

import com.cars.dao.UsersDao;
import com.cars.exceptions.UsersException;
import com.cars.exceptions.ValidateException;
import com.cars.model.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class UsersService {

	@Autowired
	private UsersDao userDao;

	public Users getUser(int id) throws ValidateException {
		if (id <= 0) {
			throw new ValidateException("ID can not be 0 or <0");
		}
		return userDao.getUserFromList(id);
	}

	public void removeUserFromList(int id) throws ValidateException {
		if (id <= 0) {
			throw new ValidateException("ID can not be 0 or < 0 or this id do not exist");
		}
		 userDao.removeUserFromList(id);
	}

	public List<Map<String, Object>> listAllUsers() {

		List<Map<String, Object>> result = userDao.listAllUsers();
			if (!result.isEmpty()) {
				return result;
			} else {
				return null;
			}
	}

	public List<Map<String, Object>> listUsersCars() {
		
		List<Map<String, Object>> result = userDao.listUsersCars();
		if (!result.isEmpty()) {
			return result;
		} else {
			return null;
		}
	}

	public List<Map<String, Object>> listOwnedCars(int id){
		
		List<Map<String, Object>> result = userDao.listOwnedCars(id);
		if (!result.isEmpty()) {
			return result;
		} else {
			return null;
		}
	}

	public void addUserToList(Users user) throws UsersException {
		if (user == null) {
			throw new UsersException("The passed object can not be null.");
		}
		userDao.addUserToList(user);
	}

	public void updateUserFromList(int id, Users user) {
		if ( id <= 0 && user == null) {
			throw new IllegalArgumentException("The passed object can not be null.");
		}
		userDao.updateUserFromList(id, user);
	}

}
