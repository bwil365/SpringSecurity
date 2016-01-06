package com.app.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.GrantedAuthority;

import com.app.entities.Role;
import com.app.entities.User;
import com.app.helper.Encryption;
import com.app.services.UserService;

public class SecurityAuthenticationProvider extends Encryption implements AuthenticationProvider {
/*
 * This is the custom AuthenticationProvider for this project.
 */
	@Autowired
	private UserService userService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		//Get username and password
		String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        
        //Retrieve user from database and encrypt incoming password
        User user = userService.findUserByUsername(name);
        String passwordEncrypted = encryptPassword(password);
        
        //Check to see if the username and password match up with the user retrieved from the database
        if (user != null && passwordEncrypted != null && user.getUserName().equals(name) && user.getPassword().equals(passwordEncrypted)) {
        	//Set roles and create authentication object
            List<GrantedAuthority> grantedAuths = new ArrayList<>();
            for(Role r : user.getRoles()) {
            	grantedAuths.add(new SimpleGrantedAuthority("ROLE_" + r.getType()));
            }
            Authentication auth = new UsernamePasswordAuthenticationToken(name, passwordEncrypted, grantedAuths);
            return auth;
        } else {
        	//If the user entered does not match the user retrieved or the user does not exist, return null and fail gracefully 
            return null;
        }
	}

	//Set authentication class 
	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
}
