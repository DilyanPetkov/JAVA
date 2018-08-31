package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class CheckMarks
 */
@WebServlet("/CheckMarks")
public class CheckMarks extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Cookie[] cookies = request.getCookies();
		String name=null;
		for(Cookie c: cookies){
			if(!(c==null)){
				name = c.getValue();
			}
		}
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/users" + "?useTimezone=true&serverTimezone=UTC", "root", "root");
			Statement statement = (Statement) connection.createStatement();
			ResultSet res = statement.executeQuery("SELECT * FROM users.subjects");
			while (res.next()) {
				if (name.equals(res.getString("studentName"))) {
					out.println(res.getString("subjectName") + " " + res.getInt("mark"));

				}

			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
