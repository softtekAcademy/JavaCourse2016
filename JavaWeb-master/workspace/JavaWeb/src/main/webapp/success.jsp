<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Email Successfully sent</title>
</head>
<body>
    <% if (request.getMethod().equalsIgnoreCase("POST")) {%>
    <h1>Success</h1>
    <br>
    <p>Hi <i>${param.userName}</i>, thanks for giving the details.</p>
    <p>Your unique password has been sent to you on <b>${param.emailID}</b></p>    
    <%} else { %>
    <h2>ERROR</h2>
    <br>
    <p>This page have to be called by POST method</p>
    <%} %>  
</body>

</html>
