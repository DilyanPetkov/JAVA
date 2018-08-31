package com.theoryx.test.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.theoryx.test.model.Mark;

public class MarkDaoImpl implements MarkDao{
	@Autowired
	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public void inputMark(Mark mark) {
		String sql = "Insert into marks values (?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] { mark.getId(),mark.getMark(), mark.getStudents_id(), mark.getSubjects_id()});
	}

	@Override
	public void updateMark(Mark mark) {
		String sql ="UPDATE marks SET mark= '"+mark.getMark()+"' WHERE id = '"+mark.getId()+"' and students_id= '"+mark.getStudents_id()+"'"
				+ " and subjects_id ='"+mark.getSubjects_id()+"';";
		jdbcTemplate.update(sql);
		
	}

	@Override
	public void deleteMark(Mark mark) {
		String sql = "DELETE from marks WHERE id = '"+mark.getId()+"' and mark = '" + mark.getMark() +"' and students_id = '"+mark.getStudents_id()+"' and subjects_id = '"+mark.getSubjects_id()+"';";
		jdbcTemplate.update(sql);	
	}

}
