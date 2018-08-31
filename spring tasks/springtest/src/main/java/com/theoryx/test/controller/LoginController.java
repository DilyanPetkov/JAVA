package com.theoryx.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.theoryx.test.model.Login;
import com.theoryx.test.model.User;
import com.theoryx.test.service.UserService;

@Controller
@SessionAttributes("usеr")
public class LoginController {
	@Autowired
	UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new Login());
		return mav;
	}

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("login") Login login) {
		ModelAndView mav = null;
		
		User user = userService.validateUser(login);
		HttpSession session = request.getSession();
		session.setAttribute("user", user);
		if (null != user) {
			if(user.getUsername().equals("admin")) {
				mav = new ModelAndView("welcomeAdmin");
				mav.addObject("firstname", user.getFirstname());
			}else {
				mav = new ModelAndView("welcome");
				mav.addObject("user", user);
				mav.addObject("firstname", user.getFirstname());
			}
			

		} else {
			mav = new ModelAndView("login");
			mav.addObject("message", "Username or Password is wrong!!");
		}
		
		return mav;
	}
}
