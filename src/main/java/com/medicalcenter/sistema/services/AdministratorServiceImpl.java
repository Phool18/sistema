package com.medicalcenter.sistema.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicalcenter.sistema.business.entities.Administrator;
import com.medicalcenter.sistema.business.repositories.AdministratorRepository;

@Service
public class AdministratorServiceImpl implements AdministratorService{
	
	@Autowired
	private AdministratorRepository administratorRepository;

	@Override
	public List<Administrator> getAllAdministrators() {
		return administratorRepository.findAll();
	}

}
