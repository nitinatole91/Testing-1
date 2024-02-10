package com.insurance.demo.service;

import java.util.List;

import com.insurance.demo.entities.User;

public interface UserService {

	
	public User loginUser(String username, String password);
	
	public User newUser(User user);
	
	public List<User> getListByCity(String city);
	
	public List<User> getListByCityandUserName(String 
			city,String userName);
}
