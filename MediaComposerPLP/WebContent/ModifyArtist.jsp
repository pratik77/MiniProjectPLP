<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Modify Artist Details</h1>
	<form:form action="insertModifiedArtist.obj" modelAttribute="artistMasterDTO" method="post">
		
		<form:input type="hidden" path="artistId" value="${artistMasterDTO.artistId}" />
		<br/>`
		
		<form:label path="artistName">Artist Name:</form:label>
		<form:input path="artistName" value="${artistMasterDTO.artistName}" required="true" />
		<br/>`

		<form:label path="artistBornDate">Artist Birth Date:</form:label>
		<form:input type="date" path="artistBornDate" value="${artistMasterDTO.artistBornDate}" required="true" />
		<br/>
		
		<form:label path="artistDiedDate">Artist Death Date:</form:label>
		<form:input type="date" path="artistDiedDate" value="${artistMasterDTO.artistDiedDate}" required="true" />
		<br/>
		
		<form:label path="artistType">Artist Type:</form:label>
		<form:input path="artistType" value="${artistMasterDTO.artistType}" required="true" />
		<br/>
		
		<form:label path="createdOn">Created On:</form:label>
		<form:input path="createdOn" value="${artistMasterDTO.createdOn}" readonly="true" required="true" />
		<br/>
		
		<form:label path="createdBy">Created By:</form:label>
		<form:input path="createdBy" value="${artistMasterDTO.createdBy}" readonly="true" required="true" />
		<br/>
		
		<form:label path="updatedOn">Created By:</form:label>
		<form:input path="updatedOn" value="${artistMasterDTO.updatedOn}" readonly="true" required="true" />
		<br/>
		
		<form:label path="updatedBy">Created By:</form:label>
		<form:input path="updatedBy" value="${artistMasterDTO.updatedBy}" readonly="true" required="true" />
		<br/>
		
		<input type="submit" value="Modify Details"/>
	</form:form>

</body>
</html>