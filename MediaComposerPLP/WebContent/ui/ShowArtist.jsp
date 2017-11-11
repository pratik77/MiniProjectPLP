<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>

		<form:form method="post" modelAttribute="artistMasterDTO"
			action="modifyOrDeleteArtist.obj">

			<table border="1">

				<tr>
					<th>Artist Id</th>
					<th>Artist Name</th>
					<th>Artist Type</th>
					<th>Artist Born Date</th>
					<th>Artist Died Date</th>
					<th>Created By</th>
					<th>Created On</th>
					<th>Updated By</th>
					<th>Updated On</th>
				</tr>

				<c:forEach items="${artistList}" var="artist">
					<tr>

						<td><form:radiobutton path="artistId"
								value="${artist.artistId }" />${artist.artistId }</td>

						<td>${artist.artistName }</td>
						<td>${artist.artistType }</td>
						<td>${artist.artistBornDate }</td>
						<td>${artist.artistDiedDate }</td>
						<td>${artist.createdBy }</td>
						<td>${artist.createdOn }</td>
						<td>${artist.updatedBy }</td>
						<td>${artist.updatedOn }</td>

					</tr>

				</c:forEach>


			</table>
			<tr>

				<td><input type="submit" name="submit" value="modify" /> <input
					type="submit" name="submit" value="delete" /></td>
			</tr>
			<br>
${message}
</form:form>

	</table>
<<<<<<< HEAD:MediaComposerPLP/WebContent/ShowArtist.jsp
<a href="insertArtist.obj">Add New Artist</a>
=======
	<br>
	<a href="ui/admin.jsp">Return to admin home page</a>
	<br>
	<br>
	<a href="ui/login.jsp">Logout</a>
>>>>>>> d4957bfc350da8cc499aa9259e73bb025ee64820:MediaComposerPLP/WebContent/ui/ShowArtist.jsp
</body>
</html>