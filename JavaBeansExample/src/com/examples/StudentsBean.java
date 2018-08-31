package com.examples;
import java.io.Serializable;

public class StudentsBean implements Serializable {
	private static final long serialVersionUID = 1L;
	String firstName;
	String lastName;
	int age;
	public StudentsBean() {
		
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
