package com.app.helper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* 
 * This abstract class is used any place where a user provides a password which needs to be encrypted.
 * The "encryptPassword" method uses "MD5" cryptographic hash algorithm.
 */
public abstract class Encryption {

	private final String ENCRYPTIONTYPE = "MD5";
	protected String encryptPassword(String plainTextPassword)  {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance(ENCRYPTIONTYPE);
			byte[] passBytes = plainTextPassword.getBytes();
			md.reset();
			byte[] encryptedPass = md.digest(passBytes);
			StringBuffer sb = new StringBuffer();
	        for(int i=0;i<encryptedPass.length;i++){
	            sb.append(Integer.toHexString(0xff & encryptedPass[i]));
	        }
	        return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			// This should never happen.  Returning null and printing out the stack trace.
			e.printStackTrace();
			return null;
		}
	}
	
}
