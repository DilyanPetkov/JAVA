package com.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InputMarks
 */
@WebServlet("/InputMarks")
public class InputMarks extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentName = request.getParameter("studentName");
		String subjectName = request.getParameter("subjectName");
		int mark = Integer.parseInt(request.getParameter("mark"));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = (Connection)DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/users" + "?useTimezone=true&serverTimezone=UTC", "root", "root");
			Statement statement = (Statement) connection.createStatement();
			 String sql = "INSERT INTO subjects " + "Values ("+"'"+studentName+"'" + ", " +"'"+subjectName+"'" +", " + mark + ")";
			 statement.executeUpdate(sql);
			 System.out.println("Inserted records into the table...");
			 response.sendRedirect("Input.jsp");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
