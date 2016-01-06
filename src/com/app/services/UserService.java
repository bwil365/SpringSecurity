package com.app.services;


import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Role;
import com.app.entities.User;
import com.app.helper.Encryption;
import com.app.repositories.RoleRepository;
import com.app.repositories.UserRepository;

@Service
public class UserService extends Encryption {

	@Resource
	private UserRepository userRepository;
	
	@Resource
	private RoleRepository roleRepository;
	
	@Transactional
	public User findUserByUsername(String username) {
		if(username != null) {
			return userRepository.findUserByUsername(username);
		}
		else {
			return null;
		}
	}
	
	@Transactional
	public boolean doesUserExist(String userName) {
		User user = userRepository.findUserByUsername(userName);
		if(user != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@Transactional
	public User createUser(User newUser) {
		User user = userRepository.findUserByUsername(newUser.getUserName());
		if(user == null) {
			Role r = new Role();
			r.setType("USER");
			Set<Role> roles = new HashSet<>();
			roles.add(r);
			newUser.setRoles(roles);
			return userRepository.save(newUser);
		}
		else {
			System.out.println("User already exists!!!!");
			return null;
		}
	}
	
	@Transactional
	public void removeUser(Long userId) throws Exception {
		User user = userRepository.findOne(userId);
		if(user == null) {
			throw new Exception("The user does not exist");
		}		
		userRepository.delete(user);
	}
}
