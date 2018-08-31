<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%session = request.getSession();
String name = "";
if(session.getAttribute("uname") == null ||session.getAttribute("uname") == "" ){
	response.sendRedirect("login.jsp");
}else{
	name = session.getAttribute("uname").toString();
} %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
	response.setHeader("Progma", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<h1>Are you sure you want to log out? </h1>
<a href="signout.jsp"><button type = "submit"> Logout</button></a>
</body>
</html>