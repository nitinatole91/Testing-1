package com.insurance.demo.serviceImplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.insurance.demo.entities.Policy;
import com.insurance.demo.repositories.PolicyRepository;
import com.insurance.demo.service.PolicyService;
@Service
public class PolicyServiceImplementation implements PolicyService{

	@Autowired
	private PolicyRepository policyRepository;
	@Override
	public Policy savePolicy(Policy policy) {
		Policy savePolicy = policyRepository.save(policy);
		return savePolicy;
	}

	@Override
	public Iterable<Policy> getAllPolicy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Policy getPolicyById(Integer Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePolicy(Integer id) {
		// TODO Auto-generated method stub
		
	}
	

}
