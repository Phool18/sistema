package com.medicalcenter.sistema.business.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicalcenter.sistema.business.entities.Administrator;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Integer>{

}
