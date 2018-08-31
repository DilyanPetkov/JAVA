package com.theoryx.test.service;


import java.util.List;

import com.theoryx.test.model.Login;
import com.theoryx.test.model.User;

public interface UserService {
	void register(User user);

	User validateUser(Login login);
	
	List<User> extract(User user);
	
	List<User> extractAll();
	
	List<User> extractAllPersonalInfo();
}
