package com.medicalcenter.sistema.business.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.medicalcenter.sistema.business.entities.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer>{

	@Query(nativeQuery = true, value = "SELECT * FROM doctors WHERE cmp = ?1")
	public Doctor validateCmpDoctor(int cmp);
}
