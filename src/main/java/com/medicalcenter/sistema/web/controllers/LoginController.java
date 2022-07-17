package com.medicalcenter.sistema.web.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.medicalcenter.sistema.business.entities.User;
import com.medicalcenter.sistema.services.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String viewLogin() {
		return "login";
	}
	
	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(@ModelAttribute User userLogin, HttpSession session) {
		ModelAndView mav = null;
		User user = userService.login(userLogin.getEmail(), userLogin.getPassword());
		if(user != null) {
			session.setAttribute("user", user);
			mav =  new ModelAndView("redirect:/home");
		}else {
			mav = new ModelAndView("login", "error", "Correo electrónico o contraseña incorrectos");
		}
		return mav;
	}
}
