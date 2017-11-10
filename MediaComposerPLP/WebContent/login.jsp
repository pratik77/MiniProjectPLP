<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body background="images/headphones.jpg" >


<form action="login.obj" method="post">
<table align="center">
<tr>
<td>User Id</td><td><input type="number" name="username" required/></td>
</tr>
<tr>
<td>Password</td><td><input type="password" name="password" required/></td>
</tr>
<tr>
<td><input type="submit" value="login"/></td>
</tr>
</table>
</form>
	<%-- <form action="login.obj" method="post">
		<table>
			<tr>
				<td>User Id</td>
				<td><input type="number" name="username" required pattern="[0-9]{1,6}" title="User Id must be numeric and maximum six digit only"/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" required pattern="[A-Za-z0-9.@_]{1,15}" title="Allowed characters in password are alphanumeric, .  _  @ only"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="login" required /></td>
			</tr>
		</table><br>
		<!-- <font size="3" color="red"> --><blink>${message}</blink><!--  --></font>
		
	</form>
 --%>
</body>
</html>