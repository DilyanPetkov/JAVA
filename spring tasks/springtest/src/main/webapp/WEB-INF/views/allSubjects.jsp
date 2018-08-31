<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="org.springframework.jdbc.core.JdbcTemplate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All subjects</title>
</head>
<body>
<form:form id="allSubjects" method="GET">
 <c:forEach var = "item" items = "${subjects}">
 	ID: <td>${item.getId()}</td>
 	Subject name: <td>${item.getSubjectName()}</td>
 	<br></br>
 </c:forEach>
 <td><a href="home.jsp">Home</a></td>
</form:form>


</body>
</html>