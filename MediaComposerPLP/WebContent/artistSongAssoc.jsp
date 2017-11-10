<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="javascript/artistSongAssoc.js"></script>

</head>
<body>
<form name="form" method="post" action="artistSongAssoc.obj" onsubmit="return validateSongs(${songList.size()})">
<h1>Artist List</h1>
<table border="1">
<c:forEach items="${artistList}" var="artist">
<tr>

<td><input type="radio" name="artistSelect" value="${artist.artistId }" required/>${artist.artistId}</td>
<td>${artist.artistName }</td>
<td>${artist.artistType }</td>
<td>${artist.artistBornDate }</td>
<td>${artist.artistDiedDate }</td>
</tr>
</c:forEach>
</table>
<br><br><br>
<h1>Songs List</h1>
<table border="1">
<c:forEach items="${songList}" var="song">
<tr>

<td><input type="checkbox" name="songSelect" value="${song.songId }"/>${song.songId}</td>
<td>${song.songName }</td>
<td>${song.songDuration }</td>
</tr>
</c:forEach>
</table>
<br>
<input type="submit" value="Associate"><br>
Click on the radio button to select composer and select check boxes to associate multiple songs to the composer

</form>
</body>
</html>