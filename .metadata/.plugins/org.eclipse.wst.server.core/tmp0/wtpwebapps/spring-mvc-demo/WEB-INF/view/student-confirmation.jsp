<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Confirmation</title>
</head>
<body>

<h4>Thank You for registering!!1</h4>
<br> 
Registered Student is ${student.firstName} ${student.lastName} from ${student.country}
<br>
Favorite Language is ${student.favoriteLanguage}
<br>
Operating Systems
<ul>
<c:forEach var="temp" items="${student.operatingSystems}">
<li>${temp}</li>
</c:forEach>
</ul>
</body>
</html>