package com.app.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.User;
/*
 * This is the user repository with only one added method to find the user from a username  
 */

public interface UserRepository extends JpaRepository<User,Long>{
	public User findUserByUsername(String username);
}
