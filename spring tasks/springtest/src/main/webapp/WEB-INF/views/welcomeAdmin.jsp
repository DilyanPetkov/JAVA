<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Welcome</title>

</head>

<body>
	Welcome ${firstname}, please select an option from the dropdown list below
	<form name = "select">
	<select name = "options" id = "options">
	<option value="nothing" selected="selected">Select an option</option>
	<option value = "home.jsp">Home</option>
	<option value = "allUsersInfo">All students personal information</option>
	<option value = "all">All students with marks</option>
	<option value = "addSubject">Add subject</option>
	<option value = "allSubjects">All subjects</option>
	<option value = "updateSubject">Update subject</option>
	<option value = "input">Input marks</option>
	<option value = "updateMark">Update mark</option>
	<option value = "deleteMark">Delete mark</option>
	</select>
	</form>
	
	<script type="text/javascript">
		var urlMenu = document.getElementById('options');
		urlMenu.onchange = function(){
			var userOption = this.options[this.selectedIndex];
			if(userOption.value != "nothing"){
				window.open(userOption.value);
			}
		}
	</script>

	<%-- <table>

		<tr>

			<td>Welcome ${firstname}</td>

		</tr>

		<tr>
			<td><a href="home.jsp">Home</a></td>
		</tr>

		<tr>
			<td><a href="allUsersInfo">All students personal information</a></td>
		</tr>
		
		<tr>
			<td><a href="all">All students with marks</a></td>
		</tr>
		
		<tr>
			<td><a href="addSubject">Add subject</a>
		</tr>
		<tr>
			<td><a href="allSubjects">All subjects</a>
		</tr>
		<tr>
			<td><a href="updateSubject">Update subject</a>
		</tr>
			<tr>
			<td><a href="input">Input marks</a></td>
		</tr>
		<tr>
			<td><a href="updateMark">Update mark</a>
		</tr>
		<tr>
			<td><a href="deleteMark">Delete mark</a>
		</tr>
	</table> --%>
<button type="button" name="back" onclick="history.back()">back</button>
</body>

</html>