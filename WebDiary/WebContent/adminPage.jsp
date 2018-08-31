<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

Cookie[] cookies = request.getCookies();
String name=null;
for(Cookie c: cookies){
	if(!(c==null)){
		name = c.getValue();
	}
}
out.println("Welcome " + name);%>
	<form action="Input.jsp" method = "post">
		<input type="submit" value="Input marks">
	</form>
	<form action = "All">
	<input type = "submit" value="Check all marks">
</form>
</body>
</html>