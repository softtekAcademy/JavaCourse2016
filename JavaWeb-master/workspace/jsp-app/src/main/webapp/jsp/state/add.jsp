<%@page import="org.slf4j.LoggerFactory"%>
<%@page import="org.slf4j.Logger"%>
<%@page import="com.softtek.academy.jsp.service.StateService"%>
<%@page import="com.softtek.academy.jsp.domain.model.State"%>
<%@page import="java.util.List"%>
<%!
	StateService stateService = new StateService();
	static final Logger LOGGER = LoggerFactory.getLogger("StateAdd");
%>
<%
	String contextPath = request.getContextPath();

	String id = "";
	String description = "";
	String msg = "";
	String disabled = "";
	
	State state = null;
	
	if (request.getParameter("save") != null) {
		id = request.getParameter("id").toString();
		description = request.getParameter("description").toString();
		
		this.LOGGER.info("Saving: {} - {}", id, description);
		
		state = stateService.save(description);		
		
		if (state != null) {
			id = state.getId().toString();
			description = state.getDescription();
			
			msg = "State saved successfully.";
			disabled = "disabled";
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
	<h3 style="color: blue; font-family: sans-serif;">New State</h3>
	
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
					<input type="text" name="description" value="<%= description %>" <%= disabled %>>
				</td>
			</tr>
		</table>
		<input type="submit" name="save" value="Save" <%= disabled %>>
	</form>
	
	<br>
	<div><%= msg %></div>
	
	<br>
	<a href="<%= contextPath %>/index.jsp">Return to Index</a>
</body>
</html>