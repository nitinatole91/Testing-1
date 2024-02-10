package com.insurance.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.demo.entities.Policy;
import com.insurance.demo.service.PolicyService;
@RestController
public class PolicyController {

	@Autowired
	private PolicyService policyService;
	@PostMapping("/savePolicy")
	public ResponseEntity<Policy> createPolicy(@RequestBody Policy policy){
		Policy savePolicy = policyService.savePolicy(policy);
		return ResponseEntity.ok().body(savePolicy);
		
	}
		
		
}
