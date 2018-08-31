package com.theoryx.test.model;

public class Mark {
	int id;
	int mark;
	int students_id;
	int subjects_id;
	public int getId() {
		return id;
		
	}
	public int getMark() {
		return mark;
	}

	public int getStudents_id() {
		return students_id;
	}
	public int getSubjects_id() {
		return subjects_id;
	}
	public void setStudents_id(int students_id) {
		this.students_id = students_id;
	}
	public void setSubjects_id(int subjects_id) {
		this.subjects_id = subjects_id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}


}
