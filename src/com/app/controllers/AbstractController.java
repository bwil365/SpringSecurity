package com.app.controllers;

import com.app.helper.Encryption;

public abstract class AbstractController extends Encryption {

	//Pages
	protected final String ProtectedHomePage = "protected/ProtectedHomePage";
	protected final String PublicHomePage = "public/PublicHomePage";
	protected final String ErrorPage = "public/Error";
	protected final String CreateAccountPage = "public/CreateAccount";
	
	//Redirects
	protected final String ProtectedHomePageRedirect = "redirect:/protected/home";
	protected final String PublicHomePageRedirect = "redirect:/public/home";
	protected final String ErrorAccountCreationRedirect = "redirect:/public/error/creation";
	protected final String CreatePageRedirect = "redirect:/public/create";
	
	
}
