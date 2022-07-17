package com.medicalcenter.sistema.services;

import com.medicalcenter.sistema.business.entities.User;

public interface UserService {

	public User login(String email, String password);
	
	public User addUser(User user);
	
	public User validateEmail(String email);
}
