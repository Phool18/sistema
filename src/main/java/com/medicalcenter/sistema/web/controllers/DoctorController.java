package com.medicalcenter.sistema.web.controllers;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.medicalcenter.sistema.business.entities.Doctor;
import com.medicalcenter.sistema.business.entities.Specialty;
import com.medicalcenter.sistema.business.entities.User;
import com.medicalcenter.sistema.services.DoctorService;
import com.medicalcenter.sistema.services.SpecialtyService;
import com.medicalcenter.sistema.services.UserService;

@Controller
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	@Autowired
	private UserService userService;
	@Autowired
	private SpecialtyService specialtyService;
	
	@RequestMapping(value = "/doctors", method = RequestMethod.GET)
	public ModelAndView viewHome(HttpSession session) {
		List<Specialty> listSpecialtys = specialtyService.getAllSpecialtys();
		ModelAndView mav = null;
		if(session.getAttribute("user")!=null) {
			User user = (User) session.getAttribute("user");
			if(user.getRole().equals("administrator")) {
				mav = new ModelAndView("administrator/doctors", "specialtys", listSpecialtys);
			}else {
				mav = new ModelAndView("doctor/home");
			}
		}else {
			mav = new ModelAndView("redirect:/login");
		}
		return mav;
	}
	
	
	  @RequestMapping(value = "/addDoctor", method = RequestMethod.POST) 
	  public ModelAndView addDoctor(HttpServletRequest request) {
		  String add = "";
		 if(userService.validateEmail(request.getParameter("email")) == null) {
			 if(doctorService.validateCmpDoctor(Integer.parseInt(request.getParameter("cmp"))) == null) {
				 User user = new User();
				 user.setEmail(request.getParameter("email"));
				 user.setPassword(request.getParameter("password"));
				 user.setRole("doctor");
				 Doctor doctor = new Doctor();
				 doctor.setCmp(Integer.parseInt(request.getParameter("cmp")));
				 doctor.setNames(request.getParameter("names"));
				 doctor.setLastnames(request.getParameter("lastnames"));
				 doctor.setPhone(request.getParameter("phone"));
				 
				 doctor.setSpecialty(specialtyService.getSpecialtyById(Integer.parseInt(request.getParameter("specialtyId"))));
				 doctor.setUser(user);
				 
				 doctorService.addDoctor(doctor);
				 add = "ok";
			 }else {
				 add = "errorCmp";
			 }
		 }else {
			 add ="errorEmail";
		 }
		 return new ModelAndView("redirect:/doctors", "add", add);
	   }
	  
}
