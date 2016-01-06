package com.app.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.entities.User;
import com.app.services.UserService;

@Controller
@RequestMapping(value="/protected")
public class ProtectedResourcesController extends AbstractController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/home")
	public String Home(Model model, Principal principal) {

		User user = userService.findUserByUsername(principal.getName());
		if(user != null) {
			model.addAttribute("firstname", user.getFirstName());
			model.addAttribute("lastname", user.getLastName());
			model.addAttribute("username", user.getUserName());
		}
		else {
			//Go to the creation page if for some reason they get past security with a user not in the database
			return CreatePageRedirect;
		}
		return ProtectedHomePage;
	}
	
	
	
}
