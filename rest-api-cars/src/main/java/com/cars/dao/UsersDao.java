package com.cars.dao;


import java.util.List;
import java.util.Map;

import com.cars.model.Users;

public interface UsersDao {

	Users getUserFromList(int id);
	
	void removeUserFromList(int id);

	void addUserToList(Users user);

	void updateUserFromList(int id, Users user);

	List<Map<String, Object>> listAllUsers();
	
	List<Map<String, Object>> listUsersCars();

}
