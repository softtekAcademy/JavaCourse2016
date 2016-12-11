<%@page import="com.softtek.academy.jsp.service.StateService"%>
<%@page import="com.softtek.academy.jsp.domain.model.State"%>
<%@page import="java.util.List"%>
<%!
	StateService stateService = new StateService();
%>
<%
	String contextPath = request.getContextPath();
	final List<State> states = stateService.list();
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>States</title>
	<meta charset="UTF-8">
</head>
<body style="font-family: sans-serif;">
	<h3 style="color: blue; font-family: sans-serif;">State List:</h3>
	
	<table border="1" style="width: 60%;">
		<tr>
			<th width="20%">Id</th>
			<th width="80%">Description</th>
		</tr>
		<% for (final State state : states) {  %>
			<tr>
				<td><a href="<%= contextPath %>/jsp/state/edit.jsp?stateId=<%=state.getId()%>"><%= state.getId() %></a></td>
				<td><%= state.getDescription() %></td>
			</tr>
		<% } %>
	</table>
	
	<br>
	<a href="<%= contextPath %>/index.jsp">Return to Index</a>
</body>
</html>