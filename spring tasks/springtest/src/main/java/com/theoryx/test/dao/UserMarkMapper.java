package com.theoryx.test.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.theoryx.test.model.Mark;
import com.theoryx.test.model.Subject;
import com.theoryx.test.model.User;

public class UserMarkMapper implements RowMapper<User> {
    @Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();

		user.setId(rs.getInt("id"));
		
		user.setUsername(rs.getString("username"));

		user.setFirstname(rs.getString("firstname"));

		user.setLastname(rs.getString("lastname"));
		
		Subject subject = new Subject();
		subject.setSubjectName(rs.getString("subjectName"));
		user.setSubject(subject);
		
		Mark mark = new Mark();
		mark.setMark(rs.getInt("mark"));
		user.setMark(mark);

		return user;
	}

}
