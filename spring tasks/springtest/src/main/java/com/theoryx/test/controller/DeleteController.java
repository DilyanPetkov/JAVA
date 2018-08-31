package com.theoryx.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.theoryx.test.model.Mark;
import com.theoryx.test.service.MarkService;


@Controller
public class DeleteController {
	@Autowired
	MarkService markService;
	
	
	@RequestMapping(value = "/deleteMark", method = RequestMethod.GET)
	public ModelAndView showInput(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("deleteMark");
		mav.addObject("mark", new Mark());
		return mav;
	}
	
	@RequestMapping(value = "/deleteMarkProcess", method = RequestMethod.POST)
	  public ModelAndView inputMark(HttpServletRequest request, HttpServletResponse response,
	      @ModelAttribute("mark") Mark mark) {
		markService.deleteMark(mark);
		ModelAndView modelAndView = new ModelAndView("deleteMark");
	    return modelAndView;
	  }
}
