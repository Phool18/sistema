package com.medicalcenter.sistema.services;

import java.util.List;

import com.medicalcenter.sistema.business.entities.Doctor;

public interface DoctorService {
	
	public List<Doctor> getAllDoctors();
	
	public Doctor getDoctorByCmp(int cmp);
	
	public boolean addDoctor(Doctor doctor);
	
	public Doctor validateCmpDoctor(int cmp);
}
