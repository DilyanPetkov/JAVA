package com.theoryx.test.model;

public class User {
	private int id;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private String adress;
	private int phone;
	private Subject subject;
	private Mark mark;
	

	public Subject getSubject() {
		return subject;
	}

	public Mark getMark() {
		return mark;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public void setMark(Mark mark) {
		this.mark = mark;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getEmail() {
		return email;
	}

	public String getAdress() {
		return adress;
	}

	public int getPhone() {
		return phone;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

}
