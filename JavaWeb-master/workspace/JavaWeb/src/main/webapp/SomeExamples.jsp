<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h2>The include action Example</h2>
		<jsp:include page="date.jsp" flush="true" />
	</center>
	
	<p>
	<%-- JSP Comment --%>
    <%
        out.println("Writing some text, ");
        out.println("<br/>");
        out.println("Running first program in JSP.");
     %>
    <%-- JSP Comment --%>
	</p>
	
	    <%-- Defining a method --%>
    <%!
    public int squareIt(int x) {
        return x*x;
    }
    %>
    <%-- Calling a method defined in a JSP. --%>
    <p>
    Square of 4 is : <%= squareIt(4) %>
    <br/>
    Square of 5 is : <%= squareIt(5) %>
    </p>
    
    <p>
    <%
		String queryData = request.getQueryString();
		out.println("Attached GET data (Query string): " + queryData);
		%>
    </p>
    
    <%-- Check HTTP Method, using Predefined Objects and JSP Expressions --%>
    <br/>
    <h3>Checking HTTP method:</h3>
    HTTP Method = <%= request.getMethod() %>
    <br/>
</body>
</html>