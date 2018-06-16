package com.cars.model;

import java.util.List;
import java.util.Map;

import javax.persistence.*;

@Entity
public class Users {
	
	@Id
    @GeneratedValue
	private int id;
	
	private String name;
	private int age;
	private String address;
	
	@OneToMany(mappedBy = "Users")
	private List<Map<String,Cars>> listOwnedCars; 
	
	public Users() {		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Map<String,Cars>> getListOwnedCars() {
		return listOwnedCars;
	}

	public void setListOwnedCars(List<Map<String,Cars>> listOwnedCars) {
		this.listOwnedCars = listOwnedCars;
	}

}
