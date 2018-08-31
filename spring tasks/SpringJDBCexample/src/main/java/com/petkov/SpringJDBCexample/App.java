package com.petkov.SpringJDBCexample;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");

//		System.out.println("------Records Creation--------");
//     	//studentJDBCTemplate.create("Dilyan", "Petkov", 22);
//     	studentJDBCTemplate.create("Georgi", "Ivanov", 52);

		System.out.println("------Listing Multiple Records--------");
		List<Student> students = studentJDBCTemplate.listStudents();
	
		studentJDBCTemplate.create("Kolyo", "Bogoev", 22);
		studentJDBCTemplate.delete(4);
		for (Student record : students) {
			System.out.print("ID : " + record.getId());
			System.out.print(", First Name : " + record.getFirstName());
			System.out.println(", Last Name : " + record.getLastName());
			System.out.println(", age : " + record.getAge());
		}
	}
}
