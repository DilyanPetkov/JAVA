package com.theoryx.test.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.theoryx.test.model.Subject;

public class SubjectDaoImpl implements SubjectDAO{
	@Autowired
	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Override
	public Subject validateSubject(Subject subject) {
		String sql = "select * from students where id='" + subject.getId() + "' and subjectName='" + subject.getSubjectName() + "'";
		List<Subject> subjects = jdbcTemplate.query(sql, new SubjectMapper());
		return subjects.size() > 0 ? subjects.get(0) : null;
	}
	@Override
	public void addSubject(Subject subject) {
		String sql = "insert into subjects values (?,?);" ;
		jdbcTemplate.update(sql, new Object[]{subject.getId(), subject.getSubjectName()});
		
	}
	@Override
	public List<Subject> listAllSubjects() {
		String sql = "SELECT * from diary.subjects";
		List<Subject> subjects = jdbcTemplate.query(sql, new SubjectMapper());
		return subjects;
	}
	@Override
	public void updateSubject(Subject subject) {
		String sql = "UPDATE subjects set subjectName = '" +subject.getSubjectName()+"' WHERE id = '"+subject.getId() + "';";
		jdbcTemplate.update(sql);
	}

}
