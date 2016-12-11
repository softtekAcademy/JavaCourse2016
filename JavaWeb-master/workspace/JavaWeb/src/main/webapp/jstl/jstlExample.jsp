<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>JSTL jar Demo</title>
</head>
<body>

    <h1>JSTL Test</h1>
    <p>
        ForEach example (counter)<br/>
        <c:forEach var="i" begin="1" end="5" step="1">
            <c:out value="${i}"/> <br />
        </c:forEach>
    </p>
	
    <br>
    <b>ForEach example 2 (print a List)</b>
    <%
       String [] s ={"A", "B", "C", "D"};
       pageContext.setAttribute("ss",s);
        
     %>
    <p>
        <c:forEach items = "${ ss }" var = "obj">
            the current obj is = ${obj} <br/>
        </c:forEach>     
    </p>
    <br>
    
    <%-- 
        Send a parameter in order to redirecto to other page automatically.
        for instance:
        http://localhost:9090/JavaWeb/jstl/jstlExample.jsp?execRedirectFlag=true
      --%>
    <c:if test="${param.execRedirectFlag != null and param.execRedirectFlag=='true' }">
        <c:redirect url="/CreditCardValidation.html" />
    </c:if>
    <p>
    execRedirectFlag = [<%=request.getParameter("execRedirectFlag") %>]
    </p>
</body>
</html>