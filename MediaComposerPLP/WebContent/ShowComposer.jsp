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
<td><form:errors path="composerId" style="color:red"/></td>


<td><form:input path="composerName" value="${composer.composerName }"/></td>
<td><form:errors path="composerName" style="color:red"/></td>



<td><form:input path="composerBornDate" value="${composer.composerBornDate }"/></td>
<td><form:errors path="composerBornDate" style="color:red"/></td>



<td><form:input path="composerDiedDate" value="${composer.composerDiedDate }"/></td>
<td><form:errors path="composerDiedDate" style="color:red"/></td>


<td><form:input path="composerCaeipiNumber" value="${composer.composerCaeipiNumber }"/></td>
<td><form:errors path="composerCaeipiNumber" style="color:red"/></td>


<td><form:input path="composerMusicSocId" value="${composer.composerMusicSocId }"/></td>
<td><form:errors path="composerMusicSocId" style="color:red"/></td>

<td><form:input path="createdBy" value="${composer.createdBy }"/></td>
<td><form:errors path="createdBy" style="color:red"/></td>

<td><form:input path="createdOn" value="${composer.createdOn }"/></td>
<td><form:errors path="createdOn" style="color:red"/></td>

<td><form:input path="updatedBy" value="${composer.updatedBy }"/></td>
<td><form:errors path="updatedBy" style="color:red"/></td>

<td><form:input path="updatedOn" value="${composer.updatedOn }"/></td>
<td><form:errors path="updatedOn" style="color:red"/></td>
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