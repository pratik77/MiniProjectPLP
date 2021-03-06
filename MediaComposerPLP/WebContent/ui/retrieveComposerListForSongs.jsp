<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form name="form" method="post" action="listSongsForComposer.obj">
		<h1>Composer List</h1>
		<table border="1">
			<c:forEach items="${composerList}" var="composer">
				<tr>

					<td><input type="radio" name="composerSelect"
						value="${composer.composerId }" required />${composer.composerId}</td>
					<td>${composer.composerName }</td>
					<td>${composer.composerBornDate }</td>
					<td>${composer.composerDiedDate }</td>
					<td>${composer.composerCaeipiNumber }</td>
					<td>${composer.composerMusicSocId }</td>
				</tr>
			</c:forEach>
		</table>
		<br> <input type="submit" value="Show Songs"><br>
		Click on the radio button to select composer and submit to see song
		details composed by the composer

	</form>
	<br>
	<a href="ui/admin.jsp">Return to admin home page</a>
	<br>
	<br>
	<a href="ui/login.jsp">Logout</a>
</body>
</html>