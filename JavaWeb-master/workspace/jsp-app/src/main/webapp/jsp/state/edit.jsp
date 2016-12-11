<%@page import="org.slf4j.LoggerFactory"%>
<%@page import="org.slf4j.Logger"%>
<%@page import="com.softtek.academy.jsp.service.StateService"%>
<%@page import="com.softtek.academy.jsp.domain.model.State"%>
<%@page import="java.util.List"%>
<%!
	StateService stateService = new StateService();
	static final Logger LOGGER = LoggerFactory.getLogger("StateEdit");
%>
<%
	String contextPath = request.getContextPath();

	String id = request.getParameter("stateId").toString();
	State state = stateService.getOne(new Long(id));
	String description = state.getDescription();
	
	String msg = "";
	
	if (request.getParameter("update") != null) {
		this.LOGGER.info("Updating: {} - {}", id, description);
		
		description = request.getParameter("description");
		state = stateService.update(new Long(id), description);
		
		if (state != null) {
			msg = "State saved successfully.";
		}
		else {
			msg = "All fields are required.";
		}
	}
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>States</title>
	<meta charset="UTF-8">
</head>
<body style="font-family: sans-serif;">
	<h3 style="color: blue; font-family: sans-serif;">Edit State</h3>
	
	<form action="" method="post">
		<table style="width: 40%;">
			<tr>
				<td width="30%">Id</td>
				<td width="70%">
					<input type="text" name="id" value="<%= id %>" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td>Description</td>
				<td>
					<input type="text" name="description" value="<%= description %>">
				</td>
			</tr>
		</table>
		<input type="submit" name="update" value="Update">
	</form>
	
	<br>
	<div><%= msg %></div>
	
	<br>
	<a href="<%= contextPath %>/index.jsp">Return to Index</a>
</body>
</html>