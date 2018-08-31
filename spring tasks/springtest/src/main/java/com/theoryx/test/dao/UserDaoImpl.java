package com.theoryx.test.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.theoryx.test.model.Login;
import com.theoryx.test.model.User;

public class UserDaoImpl implements UserDao {
	@Autowired
	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void register(User user) {
		String sql = "Insert into students values(?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] { user.getId(), user.getUsername(), user.getPassword(),
				user.getFirstname(), user.getLastname(), user.getEmail(), user.getAdress(), user.getPhone() });
	}

	public User validateUser(Login login) {

		String sql = "select * from students where username='" + login.getUsername() + "' and password='"
				+ login.getPassword()

				+ "'";

		List<User> users = jdbcTemplate.query(sql, new UserMapper());

		return users.size() > 0 ? users.get(0) : null;

	}

	@Override
	public List<User> extract(User user) {
		String sql = "SELECT students.id, students.username, students.firstname, students.lastname, subjects.subjectName, marks.mark FROM diary.marks "
				+ " left join " + " students on marks.students_id = students.id " + " left join "
				+ " subjects on marks.subjects_id = subjects.id " + " where students_id = '" + user.getId() + "';";
		List<User> users = jdbcTemplate.query(sql, new UserMarkMapper());

		return users;
	}

	@Override
	public List<User> extractAll() {
		String sql = "SELECT students.id, students.username, students.firstname, students.lastname, subjects.subjectName, marks.mark FROM diary.marks "
				+ " left join " + " students on marks.students_id = students.id " + " left join "
				+ " subjects on marks.subjects_id = subjects.id " + " where students_id = students.id " + 
				" order by students.username asc";
				
		List<User> users = jdbcTemplate.query(sql, new UserMarkMapper());

		return users;
	}

	@Override
	public List<User> extractAllPersonalInfo() {
		String sql = "SELECT * FROM diary.students where username != 'admin';";
		List<User> users = jdbcTemplate.query(sql, new UserMapper());
		
		return users;
	}
}
