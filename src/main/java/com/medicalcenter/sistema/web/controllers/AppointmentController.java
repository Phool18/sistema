package com.medicalcenter.sistema.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppointmentController {
	@RequestMapping(value = "/appointments", method = RequestMethod.GET)
	public ModelAndView viewSpecialtys() {
		return new ModelAndView("administrator/appointments");
	}
}
