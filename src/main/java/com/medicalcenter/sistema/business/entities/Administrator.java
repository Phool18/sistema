package com.medicalcenter.sistema.business.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "administrators")
@Getter
@Setter
@ToString
public class Administrator {

	@Id
	private int id;
	
	private String names;
	
	private String lastnames;
	
	private String status = "active";
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
}
