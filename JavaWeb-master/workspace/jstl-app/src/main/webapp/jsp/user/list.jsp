<%@page import="com.softtek.academy.jstl.service.UserService"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%!
	UserService userService = new UserService();
%>
<%
	request.setAttribute("users", userService.list());
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>Users</title>
	<meta charset="UTF-8">
</head>
<body style="font-family: sans-serif;">
	<h3 style="color: blue; font-family: sans-serif;">User List:</h3>
	
	<table border="1" style="width: 50%;">
		<tr>
			<th width="15%">Username</th>
			<th width="35%">Name</th>
			<th width="20%">Role</th>
			<th width="15%">Active</th>
			<th width="15%">Delete</th>
		</tr>
		<c:forEach var="user" items="${users}">
			<tr>
				<td><a href="<c:url value="/jsp/user/edit.jsp?username=${user.username}"/>">${user.username}</a></td>
				<td>${user.name}</td>
				<td>${user.userRole.description}</td>
				<td>${user.active}</td>
				<td><c:if test="${user.userRole.id != 'ADM'}">Delete</c:if></td>
			</tr>
		</c:forEach>
	</table>
	
	<br/>
	<a href="<c:url value="/index.jsp"/>">Return to Index</a>
	
</body>
</html>