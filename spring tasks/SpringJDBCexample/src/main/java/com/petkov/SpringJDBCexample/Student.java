package com.petkov.SpringJDBCexample;

public class Student {
	private int age;
	private String firstName;
	private String lastName;
	private int id;

	public int getAge() {
		return age;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getId() {
		return id;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setId(int id) {
		this.id = id;
	}
	public Student() {
		this.id = 0;
		this.age = 0;
		this.firstName = "";
		this.lastName = "";
	}
	public Student(int age, String firstName, String lastName, int id) {
		super();
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
	}

}