package com.medicalcenter.sistema.business.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medicalcenter.sistema.business.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	@Query(nativeQuery = true, value = "SELECT * FROM users WHERE email = ?1 AND password = ?2 ")
	public User validateLogin(String email, String password);
	
	@Query(nativeQuery = true, value = "SELECT * FROM users WHERE email = ?1")
	public User validateEmail(String email);
}
