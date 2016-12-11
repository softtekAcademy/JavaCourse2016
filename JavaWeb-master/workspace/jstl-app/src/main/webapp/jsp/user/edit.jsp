<%@page import="com.softtek.academy.jstl.domain.model.UserRole"%>
<%@page import="com.softtek.academy.jstl.service.UserRoleService"%>
<%@page import="com.softtek.academy.jstl.service.UserService"%>
<%@page import="com.softtek.academy.jstl.domain.model.User"%>
<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="java.util.List"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%!
	UserService userService = new UserService();
	UserRoleService userRoleService = new UserRoleService();
%>
<%
	String msg = "";
	
	User user = userService.findOne(request.getParameter("username"));
	
	if (request.getParameter("update") != null) {
		user.setPassword(request.getParameter("password"));
		user.setName(request.getParameter("name"));
		user.setUserRole(new UserRole(request.getParameter("userRoleId"), StringUtils.EMPTY));
		user.setActive(request.getParameter("active"));
		
	Boolean userUpdated = userService.update(user);
		
		if (userUpdated) {
			// Successful update
			response.sendRedirect(request.getContextPath() + "/jsp/user/list.jsp");
		}
		else {
			// Unsuccessful update
			msg = "Please check the required filds.";
		}
	}
	
	List<UserRole> userRoles = userRoleService.list();
	
	request.setAttribute("user", user);
	request.setAttribute("userRoles", userRoles);
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>Users</title>
	<meta charset="UTF-8">
</head>
<body style="font-family: sans-serif;">
	<h3 style="color: blue; font-family: sans-serif;">Edit User</h3>
	
	<form action="" method="post">
		<table style="width: 30%;">
			<tr>
				<td width="30%">Username</td>
				<td width="70%">
					<input type="text" name="username" value="${user.username}" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td>Password:*</td>
				<td>
					<input type="text" name="password" value="${user.password}">
				</td>
			</tr>			
			<tr>
				<td>Name:*</td>
				<td>
					<input type="text" name="name" value="${user.name}">
				</td>
			</tr>
			<tr>
				<td>Role:*</td>
				<td>
					<select name="userRoleId">
						<option value="">- Select -</option>
						<c:forEach var="userRole" items="${userRoles}">
							<option value="${userRole.id}" <c:if test="${userRole.id==user.userRole.id}">selected</c:if>>
								${userRole.description}
							</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>Active:</td>
				<td>
					<select name="active">
						<option value="S" <c:if test="${'S'==user.active}">selected</c:if>>S</option>
						<option value="N" <c:if test="${'N'==user.active}">selected</c:if>>N</option>
					</select>
				</td>
			</tr>
		</table>		
		
		<br>
		<input type="submit" name="update" value="Update">
	</form>
	
	<br>
	<div><%= msg %></div>
	
	<br>
	<a href="<c:url value="/jsp/user/list.jsp"/>">Return to List</a>
</body>
</html>