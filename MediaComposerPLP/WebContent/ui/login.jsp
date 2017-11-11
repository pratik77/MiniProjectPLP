<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body background="images/headphones.jpg">
	<form action="login.obj" method="post">
		<table align="center">
			<tr>
				<td>User Id</td>
				<td><input type="number" name="username" required /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" required /></td>
			</tr>
			<tr>
				<td><input type="submit" value="login" required /></td>
			</tr>
			<tr>
				<td><a href="createAnAccount.obj">Create an account</a></td>
			</tr>
		</table>
	</form>
</body>
</html>