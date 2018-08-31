package com.theoryx.test.dao;



import java.util.List;

import com.theoryx.test.model.Login;
import com.theoryx.test.model.User;

public interface UserDao {
	  void register(User user);

	  User validateUser(Login login);

	  List<User> extract(User user);
	  List<User> extractAll();
	  List<User> extractAllPersonalInfo();
	  
}
