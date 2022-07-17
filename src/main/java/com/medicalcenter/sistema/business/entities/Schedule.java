package com.medicalcenter.sistema.business.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="schedules")
@Getter
@Setter
public class Schedule {

	@Id
	private int id;
	private String day;
	private Date timeStart;
	private Date timeEnd;
	private String status = "active";
}
