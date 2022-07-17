package com.medicalcenter.sistema.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.medicalcenter.sistema.business.entities.Administrator;
import com.medicalcenter.sistema.services.AdministratorService;

@Controller
public class AdministratorController {

	@Autowired
	private AdministratorService administratorService;
	
	@RequestMapping(value = "/administrators", method = RequestMethod.GET)
	public void viewAdministratorPage() {
	 	List<Administrator> listAdministrators = administratorService.getAllAdministrators();
	 	for (Administrator administrator : listAdministrators) {
			System.out.println(administrator.toString());
		}
	}
	
}
