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
		return userDao.checkUserData(email, password);
	}

	@Override
	public User retrieveById(int id) {
		return userDao.retrieveById(id);
	}

	@Override
	public void activateUser(int id, User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getByEmail(String email) {
		
		return userDao.getByEmail(email);
	}

	@Override
	public String passwordReset(User user) {
		
		return userDao.passwordReset(user);
	}

}
