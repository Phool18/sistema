package com.medicalcenter.sistema.business.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medicalcenter.sistema.business.entities.Specialty;

@Repository
public interface SpecialtyRepository extends JpaRepository<Specialty, Integer>{
	
	@Query(nativeQuery = true, value = "SELECT * FROM specialtys WHERE type = ?1")
	public Specialty validateSpecialty(String typeSpecialty);
	
	@Query(nativeQuery = true, value = "SELECT * FROM specialtys WHERE id = ?1")
	public Specialty getSpecialtyById(int id);

}
