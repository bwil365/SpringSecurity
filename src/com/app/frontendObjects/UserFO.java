package com.app.frontendObjects;

/* 
 * This is the transaction object Jackson is using to consume the POSTed form when someone creates a user.
 * In bigger projects I have sometimes found it to be useful to provide a layer of "transaction objects" for the client allowing you to hide details of the server. 
 */

public class UserFO {
	private String username = "";
	private String password = "";
	private String firstName = "";
	private String lastName = "";
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
