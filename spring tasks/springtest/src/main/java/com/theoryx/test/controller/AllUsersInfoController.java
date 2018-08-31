package com.theoryx.test.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.theoryx.test.model.User;
import com.theoryx.test.service.UserService;

@Controller
public class AllUsersInfoController {

	@Autowired
	UserService userService;
	@RequestMapping(value = "/allUsersInfo", method = RequestMethod.GET)
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response) {
		//System.out.println("helo");
		ModelAndView mav = new ModelAndView("allUsersInfo");
		List<User> users = userService.extractAllPersonalInfo();

		mav.addObject("users", users);
		return mav;
	}

}

