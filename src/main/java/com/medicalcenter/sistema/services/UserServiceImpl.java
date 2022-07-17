package com.medicalcenter.sistema.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicalcenter.sistema.business.entities.User;
import com.medicalcenter.sistema.business.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User login(String email, String password) {
		User user = userRepository.validateLogin(email, password);
		return user;
	}

	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User validateEmail(String email) {
		return userRepository.validateEmail(email);
	}
	
}
