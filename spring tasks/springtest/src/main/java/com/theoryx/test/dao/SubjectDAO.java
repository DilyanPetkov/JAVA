package com.theoryx.test.dao;

import java.util.List;

import com.theoryx.test.model.Subject;

public interface SubjectDAO {
	Subject validateSubject(Subject subject);
	void addSubject(Subject subject);
	List<Subject> listAllSubjects();
	void updateSubject(Subject subject);
}
