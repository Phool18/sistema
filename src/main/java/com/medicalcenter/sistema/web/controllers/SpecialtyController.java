package com.medicalcenter.sistema.web.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.medicalcenter.sistema.business.entities.Specialty;
import com.medicalcenter.sistema.business.entities.User;
import com.medicalcenter.sistema.services.SpecialtyService;

@Controller
public class SpecialtyController {
	
	@Autowired
	private SpecialtyService specialtyService;
	
	@RequestMapping(value = "/specialtys", method = RequestMethod.GET)
	public ModelAndView viewSpecialtys(HttpSession session) {
		if(session.getAttribute("user")!= null) {
			User user = (User) session.getAttribute("user");
			if(user.getRole().equals("administrator")) {
				List<Specialty> listSpecialtys = specialtyService.getAllSpecialtys();
				return new ModelAndView("administrator/specialtys", "specialtys", listSpecialtys);
			}else {
				return new ModelAndView("redirect:/login");
			}
		}else {
			return new ModelAndView("redirect:/login");
		}
	}
	
	@RequestMapping(value = "/addEspecialty", method = RequestMethod.POST)
	public ModelAndView addEspecialty(@ModelAttribute Specialty specialty) {
		String add = "";
		if(specialtyService.addSpecialty(specialty)) {
			add = "ok";
		}else {
			add = "error";
		}
		return new ModelAndView("redirect:/specialtys", "add", add);
	}
	
	
	@RequestMapping(value = "/deleteSpecialty", method = RequestMethod.GET)
	public ModelAndView deleteSpecialty(@RequestParam("specialtyId") int id) {
		specialtyService.deleteSpecialty(id);
		return new ModelAndView("redirect:/specialtys");
	}
}
