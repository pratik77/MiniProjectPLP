<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table >




<form:form method="post" modelAttribute="composerMasterDTO" action="modifyOrDelete.obj">

<table border="1">
<c:forEach items="${composerList}" var="composer">
<tr>

<td><form:radiobutton path="composerId" value="${composer.composerId }"/>${composer.composerId}</td>
<td>
<td>${composer.composerName }</td>
<td>${composer.composerBornDate }</td>
<td>${composer.composerDiedDate }</td>
<td>${composer.composerCaeipiNumber }</td>
<td>${composer.composerMusicSocId }</td>
<td>${composer.createdBy }</td>
<td>${composer.createdOn }</td>
<td>${composer.updatedBy }</td>
<td>${composer.updatedOn }</td>
</td>
</tr>

</c:forEach>
<tr>
<td colspan="2"><input type="submit" name="submit" value="modify"/></td>
<td colspan="2"><input type="submit" name="submit" value="delete"/></td>
</tr>
</table>

</form:form>

</table>
</body>
</html>