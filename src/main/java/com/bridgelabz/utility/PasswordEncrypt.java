package com.bridgelabz.utility;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class PasswordEncrypt {
	
	public String passwordEncrypt(String password) {
		BCryptPasswordEncoder passwordEncode=new BCryptPasswordEncoder();
		return passwordEncode.encode(password);
		
	}

}
