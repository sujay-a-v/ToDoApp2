package com.bridgelabz.service;

import java.util.List;

import com.bridgelabz.pojo.User;

public interface UserService {
	
	public void saveUser(User user);
	
	public List<User> getAllUser();
	
	public User checkUserData(String email, String password);
	
	public User retrieveById(int id);
	
	public void activateUser(int id,User user);
	
	public User getByEmail(String email);
	
	public String passwordReset(User user);

}
