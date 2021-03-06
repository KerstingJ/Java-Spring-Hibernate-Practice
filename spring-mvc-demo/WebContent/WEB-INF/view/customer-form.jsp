<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Form</title>
<style> .error{color:red}</style>
</head>
<body>

<h2>Customer Registration Form</h2>

Fields marked with * are required<br>

<form:form action="processForm" modelAttribute="customer">

First Name<form:input path="firstName"/>

<br><br>

Last Name (*)<form:input path="lastName"/> <form:errors path="lastName" cssClass="error" />

<br><br>

Free Passes <form:input path="freePasses" /> <form:errors path="freePasses" cssClass="error" />

<br><br>

Zipcode: <form:input path="zipcode"/> <form:errors path="zipcode" cssClass="error" />

<br><br>

Course Code: <form:input path="course"/> <form:errors path="course" cssClass="error" />

<br><br>

<input type="submit" value="submit"/>

</form:form>
</body>
</html>