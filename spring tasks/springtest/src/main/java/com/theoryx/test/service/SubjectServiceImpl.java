package com.theoryx.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.theoryx.test.dao.SubjectDAO;
import com.theoryx.test.model.Subject;

public class SubjectServiceImpl implements SubjectService{
	@Autowired
	public SubjectDAO subjectDAO;

	@Override
	public Subject validateSubject(Subject subject) {
		return subjectDAO.validateSubject(subject);
	}

	@Override
	public void addSubject(Subject subject) {
		subjectDAO.addSubject(subject);
		
	}

	@Override
	public List<Subject> listAllSubjects() {
		return subjectDAO.listAllSubjects();
	}

	@Override
	public void updateSubject(Subject subject) {
		subjectDAO.updateSubject(subject);
		
	}
}
