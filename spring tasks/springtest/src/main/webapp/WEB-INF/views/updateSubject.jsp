<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update subjects</title>
</head>
<body>
	<form:form id="updateSubject" modelAttribute="subject" action="updateSubjectProcess"
		method="post">
		<table align="center">
			<tr>
				<td><form:label path="id">Subject id</form:label>
				</td>
				<td><form:input path="id" name="id"
						id="id" /></td>
			</tr>
			<tr>
				<td><form:label path="subjectName">Subject name</form:label>
				</td>
				<td><form:input path="subjectName" name="subjectName"
						id="subjectName" /></td>
			</tr>
			<tr>

                        <td>
                            <form:button id="updateSubject" name="updateSubject">Update subject</form:button>
                        </td>
           </tr>
  
		</table>
	</form:form>
	<a href="home.jsp">Home</a>
</body>
</html>