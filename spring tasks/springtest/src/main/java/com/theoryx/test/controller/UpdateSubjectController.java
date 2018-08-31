package com.theoryx.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.theoryx.test.model.Subject;
import com.theoryx.test.service.SubjectService;


@Controller
public class UpdateSubjectController {
	@Autowired
	SubjectService subjectService;
	
	
	@RequestMapping(value = "/updateSubject", method = RequestMethod.GET)
	public ModelAndView showInput(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("updateSubject");
		mav.addObject("subject", new Subject());
		return mav;
	}
	
	@RequestMapping(value = "/updateSubjectProcess", method = RequestMethod.POST)
	  public ModelAndView inputMark(HttpServletRequest request, HttpServletResponse response,
	      @ModelAttribute("subject") Subject subject) {
		subjectService.updateSubject(subject);
		ModelAndView modelAndView = new ModelAndView("updateSubject");
	    return modelAndView;
	  }
}
