<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id='students' scope='session' class = 'com.examples.StudentsBean' />
	<jsp:setProperty name='students' property='firstName' value='Dilyan' />
	<jsp:setProperty name='students' property='lastName' value='Petkov' />
	<jsp:setProperty name='students' property='age' value='22' />
	<p>
		Student first name:
		<jsp:getProperty property='firstName' name='students' />
	</p>
	<p>
		Student last name:
		<jsp:getProperty property='lastName' name='students' />
	</p>
	<p>
		Student age:
		<jsp:getProperty property='age' name='students' />
	</p>
</body>
</html>