package com.example;

import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class First {
	public static void main(String[] args) {
		try {
			Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "root");
			Statement st = (Statement) connection.createStatement();
			ResultSet res = st.executeQuery("SELECT * FROM users.new_table");
			while(res.next()) {
				if(res.getString("user_name").equals("admin")) {
					System.out.println("a");
				}
			}
			
		}catch(Exception e) {
			System.out.println("n");
		}
	}
}
