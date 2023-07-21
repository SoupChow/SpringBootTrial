package com.jpa.test.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jpa.test.entities.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	@Query("select u from User u")
	public List<User> getAllUser();
	
	@Query("select u From User u Where u.name = :n and u.city = :c")
	public List<User> getUserByNameandCity(@Param("n") String name, @Param("c") String city);
	
	@Query(value = "select * from user",nativeQuery=true)
	public List<User> getUsers();
	
}