<%
	final String contextPath = request.getContextPath();
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>JSP Application</title>
	<meta charset="UTF-8">
</head>
<body style="font-family: sans-serif;">
	<h2 style="font-family: sans-serif;">JSP Application</h2>
	<hr>
	<h3>Examples:</h3>
	<ul>
		<li>--------------------------------------------</li>
		<li><a href="<%= contextPath %>/jsp/state/list.jsp">State List</a></li>
		<li><a href="<%= contextPath %>/jsp/state/add.jsp">New State</a></li>
		<li>--------------------------------------------</li>
		<li><a href="<%= contextPath %>/cities">City List</a></li>
		<li><a href="<%= contextPath %>/view/cityAdd.html">New City</a></li>
	</ul>
</body>
</html>