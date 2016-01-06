package com.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/security")
public class SecurityController extends AbstractController {
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login() {
		return "security/Login";
	}
	
	@RequestMapping(value="/403", method = RequestMethod.GET)
	public String forbidden(Model model) {
		model.addAttribute("message","Forbidden");
		return "security/ServerError";
	}
	
	@RequestMapping(value="/404", method = RequestMethod.GET)
	public String notFound(Model model) {
		model.addAttribute("message","Not Found");
		return "security/ServerError";
	}
	
	@RequestMapping(value="/500", method = RequestMethod.GET)
	public String serverError(Model model) {
		model.addAttribute("message","Server Error");
		return "security/ServerError";
	}
	
}
