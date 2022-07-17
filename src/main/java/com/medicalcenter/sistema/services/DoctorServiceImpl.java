package com.medicalcenter.sistema.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicalcenter.sistema.business.entities.Doctor;
import com.medicalcenter.sistema.business.repositories.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService{
	
	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public List<Doctor> getAllDoctors() {
		// TODO Auto-generated method stub
		return doctorRepository.findAll();
	}

	@Override
	public Doctor getDoctorByCmp(int cmp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addDoctor(Doctor doctor) {
		if(doctorRepository.validateCmpDoctor(doctor.getCmp()) == null) {
			doctorRepository.save(doctor);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Doctor validateCmpDoctor(int cmp) {
		return doctorRepository.validateCmpDoctor(cmp);
	}

}
