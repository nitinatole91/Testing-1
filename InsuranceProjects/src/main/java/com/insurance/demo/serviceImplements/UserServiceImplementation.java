package com.insurance.demo.serviceImplements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.insurance.demo.entities.User;
import com.insurance.demo.exceptions.UserNotFoundException;
import com.insurance.demo.repositories.UserRepository;
import com.insurance.demo.service.UserService;

@Service
public class UserServiceImplementation implements UserService  {
	@Autowired
	private UserRepository userRepository;
	
	///service implementation.
	@Override
	public User loginUser(String username, String password) {
		
		User user = userRepository.findByUserName(username);
		if (user == null) {
			throw new UserNotFoundException("You entered incorrect username.");
		} else {
			if (user.getUserPassword().equals(password)) {
				return user;
			}
			throw new UserNotFoundException("You entered incorrect password.");
			
		}
		
	}

	@Override
	public User newUser(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public List<User> getListByCity(String city) {
		List<User> listUser = userRepository.findByCity(city);
		return listUser;
	}

	@Override
	public List<User> getListByCityandUserName(String city, String userName) {
		List<User> listUser=userRepository.findByCityandUserName(city, userName);
		return listUser;
	}
	
	
	////User Repository method 
	

}
