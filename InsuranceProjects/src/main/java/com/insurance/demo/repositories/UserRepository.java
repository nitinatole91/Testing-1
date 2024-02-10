package com.insurance.demo.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.insurance.demo.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Serializable> {

	public User findByUserName(String userName);

	// this is the custom query in project- b alias name-user is tablename
	@Query(value = "select * from user_data s where city=?1", nativeQuery = true)
	public List<User> findByCity(String city); // ,String firstname-2
	
	
	
	//if you write nativeQuery=false then we will get compile time error
	@Query(value = "select * from user_data c where city=?1 and username=?2", nativeQuery = true)
	List<User> findByCityandUserName(String city, String username);

}
