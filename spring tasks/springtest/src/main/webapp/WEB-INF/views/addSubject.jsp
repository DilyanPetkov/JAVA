<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add subjects</title>
</head>
<body>
	<form:form id="addSubject" modelAttribute="subject" action="addSubjectProcess"
		method="post">
		<table align="center">
			<tr>
				<td><form:label path="subjectName">Subject name</form:label>
				</td>
				<td><form:input path="subjectName" name="subjectName"
						id="subjectName" /></td>
			</tr>
			<tr>

                        <td>
                            <form:button id="addSubject" name="addSubject">Add subject</form:button>
                        </td>
           </tr>
  
		</table>
	</form:form>
	<a href="home.jsp">Home</a>
	
</body>
</html>