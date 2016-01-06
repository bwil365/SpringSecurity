package com.app.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.entities.User;
import com.app.frontendObjects.UserFO;
import com.app.services.UserService;

@Controller
@RequestMapping(value="/public")
public class PublicResourcesController extends AbstractController{

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/home")
	public String home() {
		return PublicHomePage;
	}
	
	//Error pages
	@RequestMapping(value="/error/creation")
	public String errorCreation(Model model) {
		model.addAttribute("message", "There was an error creating user");
		return ErrorPage;
	}

	//Create Account
	@RequestMapping(value="/create",method=RequestMethod.GET)
	public String createAccountPage(Model model) {
		UserFO userForm = new UserFO();    
        model.addAttribute("userForm", userForm);
		return CreateAccountPage;
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public String createAccountSubmit(@ModelAttribute("userForm") UserFO user, Model model) {
		//Get the new user's information and then create the new user 
		if(user.getUsername() != null && user.getPassword() != null) {	
			user.setPassword(encryptPassword(user.getPassword()));
			User newUser = userService.createUser(new User(user));
			if(newUser == null) {
				return ErrorAccountCreationRedirect;
			}
		}
		else {
				return ErrorAccountCreationRedirect;
		}
		
		return ProtectedHomePageRedirect;
	}

}
