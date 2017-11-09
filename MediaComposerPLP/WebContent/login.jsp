<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="login.obj" method="post">
		<table>
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
		</table>
	</form>

</body>
</html>