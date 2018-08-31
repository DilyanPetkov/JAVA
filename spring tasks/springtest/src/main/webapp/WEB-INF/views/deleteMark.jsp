<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete mark</title>
</head>
<body>
	<form:form id="deleteMark" modelAttribute="mark" action="deleteMarkProcess"
		method="post">
		<table align="center">
			<tr>
				<td><form:label path="id">Mark id</form:label>
				</td>
				<td><form:input path="id" name="id"
						id="id" /></td>
			</tr>
			<tr>
				<td><form:label path="students_id">Student's id</form:label>
				</td>
				<td><form:input path="students_id" name="students_id"
						id="students_id" /></td>
			</tr>
			<tr>
				<td><form:label path="subjects_id">Subjects's id</form:label>
				</td>
				<td><form:input path="subjects_id" name="subjects_id"
						id="subjects_id" /></td>
			</tr>
			<tr>
				<td><form:label path="mark">Mark</form:label></td>
				<td><form:input path="mark" name="mark" id="mark" /></td>
			</tr>
			<tr>
                        <td></td>
                        <td>
                            <form:button id="deleteMark" name="deleteMark">Delete mark</form:button>
                        </td>
                    </tr>
		</table>
	</form:form>
	<a href="home.jsp">Home</a>
	
</body>
</html>