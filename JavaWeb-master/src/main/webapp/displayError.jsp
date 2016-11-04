<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page isErrorPage="true" %>
<%@ page import="java.io.StringWriter,java.io.PrintWriter" %>
<%@ page import="org.apache.log4j.Logger" %>
<html>
<head>
    <title>Error Page</title>
</head>
<body>
<%!
    private static final Logger log = Logger.getLogger("displayError");
%>

    <h3>Writing some message to log (using Log4j according to log4j.xml configuration)...</h3>
    <%
    log.info("Message [INFO] sent to log using Log4J !!!");
    log.warn("Message [WARN] sent to log using Log4J !!!");
    log.debug("Message [DEBUG] sent to log using Log4J !!!");
    %>

    <%-- exception.printStackTrace(response.getWriter()); --%>
    <%
    if (exception != null) {
        StringWriter stackTraceMsg = new StringWriter();
        exception.printStackTrace(new PrintWriter(stackTraceMsg));
     %>
	    <h1>Sorry :Error occurred</h1>
	    <b>Stack trace:</b>
	    
	    <br/>     
	    <pre>
    <%        
        out.println(stackTraceMsg.toString());
        log.error("Exception received:");
        log.error(stackTraceMsg.toString());
     %>
        </pre>     
    <%
    }
    %>
</body>
</html>
