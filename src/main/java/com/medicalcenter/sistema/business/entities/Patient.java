package com.medicalcenter.sistema.business.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "patients")
@Getter
@Setter
public class Patient {
	
	@Id
	private int id;
	private String dni;
	private String names;
	private String lastNames;
	private String address;
	private String date_of_birth;
	private String gender;
	private String phone;
	private String status = "active";

}
