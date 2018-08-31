package com.petkov.SpringJDBCexample;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class StudentJDBCTemplate implements StudentDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void create(String firstName, String lastName, int age) {
		String SQL = "INSERT INTO diary.students (firstName, lastName, age) values (?, ?, ?)";
		this.jdbcTemplateObject.update(SQL,  firstName, lastName, age);
		System.out.println("Created student with first name " + firstName + " , last name "+lastName+" and age " +age);
		return;
	}

	public List<Student> listStudents() {
		String SQL = "SELECT * FROM diary.students";
		List<Student> students = this.jdbcTemplateObject.query(SQL, new StudentMapper());
		return students;
	}
	
//	public DataSource getDataSource() {
//		return dataSource;
//	}
	public void delete(int id) {
		String SQL = "DELETE FROM diary.students WHERE ID = "+id+";";
		this.jdbcTemplateObject.update(SQL);
	}
	public void update(int id, int age) {
		String SQL = "UPDATE diary.students\n" + 
				"SET age = "+age+"\n" + 
				"WHERE ID = "+ id+";";
		this.jdbcTemplateObject.update(SQL);

	}
}
