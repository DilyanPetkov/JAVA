<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="org.springframework.jdbc.core.JdbcTemplate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All users info</title>
</head>
<body>
<form:form id="allUsersInfo" method="GET">
 <c:forEach var = "item" items = "${users}">
 	Username: <td>${item.getUsername()}</td>
 	Password: <td>${item.getPassword()}</td>
 	First name: <td>${item.getFirstname()}</td>
 	Last name: <td>${item.getLastname()}</td>
 	Email: <td>${item.getEmail()}</td>
 	Adress: <td>${item.getAdress()}</td>
 	Phone: <td>${item.getPhone()}</td>
 	<br></br>
 </c:forEach>
 <td><a href="home.jsp">Home</a></td>
</form:form>


</body>
</html>