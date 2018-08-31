package com.theoryx.test.controller;

import java.util.List;

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

import com.theoryx.test.model.User;
import com.theoryx.test.service.UserService;

@Controller
@SessionAttributes("usеr")
public class ViewController {

	@Autowired
	UserService userService;
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("user") User user) {
		//System.out.println("helo");
		ModelAndView mav = new ModelAndView("view");
		HttpSession session = request.getSession();
		user = (User) session.getAttribute("user"); //ne namira user-a
		List<User> users = userService.extract(user);
		if(users.isEmpty()) {
			System.out.println("empty");
		}
		mav.addObject("users", users);
		return mav;
	}

}
