package com.insurance.demo.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.demo.entities.Policy;
@Repository
public interface PolicyRepository extends JpaRepository<Policy, Serializable>{
	public Policy findById(Integer Id);
}
