package com.medicalcenter.sistema.services;

import java.util.List;
import com.medicalcenter.sistema.business.entities.Specialty;

public interface SpecialtyService {
	
	public List<Specialty> getAllSpecialtys();
	
	public Specialty getSpecialtyById(int id);
	
	public boolean addSpecialty(Specialty specialty);
	
	public void deleteSpecialty(int id);

}
