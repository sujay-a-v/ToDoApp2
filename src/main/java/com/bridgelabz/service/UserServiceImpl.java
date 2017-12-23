package com.bridgelabz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.dao.UserDao;
import com.bridgelabz.pojo.User;
import com.bridgelabz.utility.PasswordEncrypt;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	public PasswordEncrypt passwordEncrypt;

	@Override
	public void saveUser(User user) {
		boolean status=userDao.isUserExist(user.getUserEmail());
		if(status) {
			System.out.println("User exist");
			return;
		}
		String password=passwordEncrypt.passwordEncrypt(user.getUserPassword());
		user.setUserPassword(password);
		userDao.saveUser(user);
	}

	@Override
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

	@Override
	public User checkUserData(String email, String password) {
		// TODO Auto-generated method stub
		return userDao.checkUserData(email, password);
	}

	@Override
	public User retrieveById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void activateUser(int id, User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String passwordReset(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
