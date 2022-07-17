package com.medicalcenter.sistema.business.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "appointments")
@Getter
@Setter
public class Appointment {

	@Id
	private int id;
	private Date date;
	private Date time;
	private String observation;
	private String status = "active";
}
