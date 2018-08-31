package com.theoryx.test.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.theoryx.test.model.Mark;

public class MarkMapper implements RowMapper<Mark>{

	@Override
	public Mark mapRow(ResultSet rs, int rowNum) throws SQLException {
		Mark mark = new Mark();
		mark.setId(rs.getInt("id"));
		mark.setMark(rs.getInt("mark"));
		mark.setStudents_id(rs.getInt("students_id"));
		mark.setSubjects_id(rs.getInt("subjects_id"));;
		return mark;
	}

}
