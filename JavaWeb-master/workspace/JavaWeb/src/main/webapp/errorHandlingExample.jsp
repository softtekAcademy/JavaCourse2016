<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page errorPage="displayError.jsp" %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<title>Error Handling Example</title>
</head>
<body>
<%
   // Throw an exception to invoke the error page
   int s = 10;
   if (s < 5) {
      out.println("Bingo!!well done!! You're right");
   }
   else {
      throw new RuntimeException("Error found - ");
   }
%>

</body>
</html>
