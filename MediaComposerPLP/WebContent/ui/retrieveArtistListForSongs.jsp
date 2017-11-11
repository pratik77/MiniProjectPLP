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
	<form name="form" method="post" action="listSongsForArtsist.obj">
		<h1>Artist List</h1>
		<table border="1">
			<tr>
				<th>Artist Id</th>
				<th>Artist Name</th>
				<th>Artist Type</th>
				<th>Artist Born Date</th>
				<th>Artist Died Date</th>


				<c:forEach items="${artists}" var="artist">
					<tr>

						<td><input type="radio" name="artistSelect"
							value="${artist.artistId }" required />${artist.artistId}</td>
						<td>${artist.artistName }</td>
						<td>${artist.artistType }</td>
						<td>${artist.artistBornDate }</td>
						<td>${artist.artistDiedDate }</td>
					</tr>
				</c:forEach>
		</table>
		<br> <input type="submit" value="Show Songs"><br>
		Click on the radio button to select artist and submit to see song
		details composed by the artist

	</form>
	<br>
	<a href="ui/admin.jsp">Return to admin home page</a>
	<br>
	<br>
	<a href="ui/login.jsp">Logout</a>
</body>
</html>