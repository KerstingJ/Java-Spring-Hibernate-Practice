<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirmation</title>
</head>
<body>
<h3>Congratulations</h3>
Name: ${customer.firstName} ${customer.lastName}
<br>
Free Passes: ${customer.freePasses}
<br>
Zip code: ${customer.zipcode}
<br>
Course code: ${customer.course}

</body>
</html>