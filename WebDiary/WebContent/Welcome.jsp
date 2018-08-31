<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String res = request.getParameter("uname");
Cookie c = new Cookie("uname", res);
response.addCookie(c);
if(res.equals("admin")){
	response.sendRedirect("adminPage.jsp");
}
else{
	response.sendRedirect("studentPage.jsp");
}
%>
</body>
</html>