package com.theoryx.test.service;

import java.util.List;

import com.theoryx.test.model.Subject;

public interface SubjectService {
	Subject validateSubject(Subject subject);
	void addSubject(Subject subject);
	List<Subject> listAllSubjects();
	public void updateSubject(Subject subject);
}
