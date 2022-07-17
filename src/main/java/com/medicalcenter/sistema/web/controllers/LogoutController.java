package com.medicalcenter.sistema.web.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		return new ModelAndView("redirect:/login");
	}
}
