<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix= "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
    <b>Username :</b> ${param.userName}<br>
    
	<c:catch var="c">
		<%
		int age = Integer.parseInt(request.getParameter("userAge"));
		%>
		<b>User Age : </b> ${param.userAge}<br>
	</c:catch>
	<c:if test = "${ c != null }">
        Oops... exception raised: ${c} <br>
	</c:if>
	
	<b>User Height :</b> ${param.userHeight}

</body>
</html>