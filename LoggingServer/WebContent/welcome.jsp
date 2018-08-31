<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Welcome ${uname}
<% 
session = request.getSession();
String name = "";
if(session.getAttribute("uname") == null ||session.getAttribute("uname") == "" ){
	response.sendRedirect("login.jsp");
}else{
	name = session.getAttribute("uname").toString();
}
%>
	
	
	<a href = "videos.jsp">Videos</a>
	<a href = "logout.jsp">Click here to logout</a>
</body>
</html>