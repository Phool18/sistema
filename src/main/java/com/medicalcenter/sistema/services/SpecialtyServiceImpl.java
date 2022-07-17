package com.medicalcenter.sistema.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicalcenter.sistema.business.entities.Specialty;
import com.medicalcenter.sistema.business.repositories.SpecialtyRepository;

@Service
public class SpecialtyServiceImpl implements SpecialtyService{

	@Autowired
	public SpecialtyRepository specialtyRepository;
	
	@Override
	public List<Specialty> getAllSpecialtys() {
		return specialtyRepository.findAll();
	}

	@Override
	public boolean addSpecialty(Specialty specialty) {
		if(specialtyRepository.validateSpecialty(specialty.getType()) == null) {
			specialtyRepository.save(specialty);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public void deleteSpecialty(int id) {
		specialtyRepository.deleteById(id);
	}

	@Override
	public Specialty getSpecialtyById(int id) {
		return specialtyRepository.getSpecialtyById(id);
	}

}
