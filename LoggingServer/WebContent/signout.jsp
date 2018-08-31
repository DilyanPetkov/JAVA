<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
	response.setHeader("Progma", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<% 
session = request.getSession();
String name = "";
if(session.getAttribute("uname") == null ||session.getAttribute("uname") == "" ){
	response.sendRedirect("login.jsp");
}else{
	name = session.getAttribute("uname").toString();
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Signout page</h1>
<%
	if(session.getAttribute("uname") != null){
		session.removeAttribute("uname");
		request.getSession(false);
		session.setAttribute("uname", 0);
		session.invalidate();
		response.sendRedirect("login.jsp");
	}
%>
</body>
</html>