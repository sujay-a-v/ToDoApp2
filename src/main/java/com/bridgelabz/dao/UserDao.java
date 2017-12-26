package com.bridgelabz.dao;

import java.util.List;

import com.bridgelabz.pojo.Notes;
import com.bridgelabz.pojo.User;

public interface UserDao {
	
	public void saveUser(User user);
	
	public List<User> getAllUser();

	public boolean isUserExist(String email);
	
	public User checkUserData(String email, String password);
	
	public User retrieveById(int id);
	
	public void activateUser(int id,User user);
	
	public User getByEmail(String email);
	
	public String passwordReset(User user);
	
}
