package com.theoryx.test.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.theoryx.test.model.Subject;
import com.theoryx.test.service.SubjectService;

@Controller
public class AllSubjectsController {

	@Autowired
	SubjectService subjectService;
	@RequestMapping(value = "/allSubjects", method = RequestMethod.GET)
	public ModelAndView view(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("allSubjects");
		List<Subject> subjects = subjectService.listAllSubjects();
		mav.addObject("subjects", subjects);
		return mav;
	}

}

