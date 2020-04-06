<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h1>Contact Manager Application</h1>
<table border="1">
<tr>
<th>No</th>
<th>Name</th>
<th>Email</th>
<th>Address</th>
<th>Phone</th>
<th>Action</th>
</tr>

<c:forEach var="contact" items="${listcontacts}" varStatus="status">
<tr>
<td>${status.index+1}</td>
<td>${contact.name}</td>
<td>${contact.email}</td>
<td>${contact.address}</td>
<td>${contact.phone}</td>
<td>
<a href="">Edit</a>
<a href="">Delete</a>
</td>
</tr>
</c:forEach>

</table>
</div>
</body>
</html>