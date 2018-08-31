<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Please input marks for all users
	<form action="InputMarks" method = "post">
		<input type="text" name="studentName"><br> 
		<input type="text" name="subjectName"><br> 
		<input type="text"name="mark"><br> 
		<input type=submit value="Submit marks">
	</form>
	
	Go back to login page
	<form action="login.jsp" method = "post">
		<input type=submit value="Go back">
	</form>
</body>
</html>