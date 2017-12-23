package com.bridgelabz.utility;

public interface Token {
	
	public String generateToken(int id);
	
	public int validateToken(String token);

}
