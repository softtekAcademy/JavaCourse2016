<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	final String contextPath = request.getContextPath();
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>JSTL Application</title>
	<meta charset="UTF-8">
</head>
<body style="font-family: sans-serif;">
	<h2 style="font-family: sans-serif;">JSTL Application</h2>
	<hr>
	<h3>Examples:</h3>
	<ul>
		<li>--------------------------------------------</li>
		<li><a href="<c:url value="/jsp/cart/list.jsp"/>">Carts</a></li>
		<li><a href="<c:url value="/jsp/user/list.jsp"/>">Users</a></li>
	</ul>
</body>
</html>