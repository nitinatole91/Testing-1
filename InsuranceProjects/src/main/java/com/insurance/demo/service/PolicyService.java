package com.insurance.demo.service;

import com.insurance.demo.entities.Policy;

public interface PolicyService {

	//List<Policy> or Iterable<Policy>
		public Iterable<Policy> getAllPolicy(); //public List<Policy>
		public Policy savePolicy(Policy policy);
		public Policy getPolicyById(Integer Id);
		public void deletePolicy(Integer id);
}
