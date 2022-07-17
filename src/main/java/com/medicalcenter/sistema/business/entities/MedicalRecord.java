package com.medicalcenter.sistema.business.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="medical_record")
@Getter
@Setter
public class MedicalRecord {

	@Id
	private int id;
	private String symptons;
	private String diagnosis;
	private String treatment;
	private String status = "active";
}
