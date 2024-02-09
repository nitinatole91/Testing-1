package com.insurance.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.demo.entities.Policy;
import com.insurance.demo.entities.User;
import com.insurance.demo.service.PolicyService;
import com.insurance.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private PolicyService policyService;

	/*
	 * This method is used to login the user to the insurance system.
	 */
	@PostMapping("/login")
	public ResponseEntity<User> loginUser(@RequestBody User user) throws Exception {
		String username = user.getUserName();
		String password = user.getUserPassword();
		user = userService.loginUser(username, password);
		return ResponseEntity.ok().body(user);

	}

	// This method is save new user to the insurance system.
	@PostMapping("/save")
	public ResponseEntity<User> createNewUser(@RequestBody User user) throws Exception {
		User users = userService.newUser(user);
		return ResponseEntity.ok().body(users);
	}

	// Design Rest API which gives the list of city user
	@GetMapping("/getcity/{city}")
	public ResponseEntity<List<User>> getUserByCity(@PathVariable("city") String city) {
		List<User> user = userService.getListByCity(city);
		return ResponseEntity.ok().body(user);
	}

	@GetMapping("/getcity/{city}/{username}")
	public ResponseEntity<List<User>> getUserByCityandUserName(@PathVariable("city") String city,
			@PathVariable("username") String userName) {
		List<User> listUser = userService.getListByCityandUserName(city, userName);
		return ResponseEntity.ok().body(listUser);
	}

	@PostMapping("/saveUserPolicy")
	public ResponseEntity<User> saveUserPolicy(@RequestBody User user) throws Exception {
		User user1 = userService.newUser(user);
		List<Policy> policies = user.getPolicyList();
		for (Policy policy : policies) {
			policy.setUserId(user.getId());
			policyService.savePolicy(policy);
		}
		return ResponseEntity.ok().body(user1);
	}

	@GetMapping("/getData")
	public ResponseEntity<String> getString() {

		return ResponseEntity.ok("Hello java");
	}


	@GetMapping("/newChanges")
	public ResponseEntity<String> getNewString() {

		return ResponseEntity.ok("This is the new file changes");
	}
}
