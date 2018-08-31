<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="org.springframework.jdbc.core.JdbcTemplate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Average</title>
</head>
<body>
<form:form id="average"  modelAttribute="user" method="GET">
	Average is: ${average}
	<td><a href="home.jsp">Home</a>
	</form:form>
	
</body>
</html>