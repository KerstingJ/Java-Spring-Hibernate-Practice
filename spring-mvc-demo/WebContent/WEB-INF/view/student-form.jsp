<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Registration Form</title>
</head>
<body>

	<form:form action="processForm" modelAttribute="student">
	
	First Name: <form:input path="firstName" />
	<br><br>
	
	Last Name: <form:input path="lastName" />
	
	<br><br>
	Country: 
	<form:select path="country"> 
		<form:options items="${countryOptions}" />
	</form:select>
	<br><br>
	
	<form:radiobutton path="favoriteLanguage" value="java"/> Java
	<form:radiobutton path="favoriteLanguage" value="python"/> Python
	<form:radiobutton path="favoriteLanguage" value="ruby"/> Ruby
	<form:radiobutton path="favoriteLanguage" value="C"/> C
	
	<br><br>
	
	Operating Systems:
	Windows <form:checkbox path="operatingSystems" value="Windows"/>
	Linux <form:checkbox path="operatingSystems" value="linux"/>
	Mac OS <form:checkbox path="operatingSystems" value="Mac OS"/>
		
	
	<br><br>
	<input type="submit" value="submit"/>
	
	</form:form>






</body>
</html>