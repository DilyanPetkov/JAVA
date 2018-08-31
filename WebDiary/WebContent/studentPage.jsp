<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%Cookie[] cookies = request.getCookies();
String name=null;
for(Cookie c: cookies){
	if(!(c==null)){
		name = c.getValue();
	}
}
out.println("Welcome " + name);
%>
<form action="CheckMarks">
		<input type="submit" value="Check marks">
	</form>
	<form action = "Average">
	<input type = "submit" value = "Check average">
	</form>
</body>
</html>