package com.theoryx.test.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.theoryx.test.dao.UserDao;
import com.theoryx.test.model.Login;
import com.theoryx.test.model.User;

public class UserServiceImpl implements UserService {

	@Autowired
	public UserDao userDao;

	public void register(User user) {
		userDao.register(user);
	}

	public User validateUser(Login login) {
		return userDao.validateUser(login);
	}

	@Override
	public List<User> extract(User user) {
		return userDao.extract(user);
	}

	@Override
	public List<User> extractAll() {
		return userDao.extractAll();
	}

	@Override
	public List<User> extractAllPersonalInfo() {
		return userDao.extractAllPersonalInfo();
	}



}
