<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.*"%>
<%@ page import="com.softtek.java.academy.web.lesson2.bean.*"  
         import="com.softtek.java.academy.web.lesson3.dao.ProductDAO"%>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>

<%@ taglib uri="http://logging.apache.org/log4j/tld/log" prefix="log" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Product List</title>
</head>
<body>
    <p/>

    <%-- Writing a log message using Log4j TagLib. --%>
    <log:info>Writing a INFO message in log file</log:info>
    <log:warn>Writing a WARN message in log file</log:warn>
    <log:debug>Writing a DEBUG message in log file</log:debug>

    <jsp:useBean id="dao" class="com.softtek.java.academy.web.lesson3.dao.ProductDAO"/>

    <% 
        List<ProductBean> prodList = dao.getProductList();
        // Push in scope page.
        pageContext.setAttribute("prodList", prodList);
     %>

    <table border="1">
        <tr>
            <th>Product ID</th>
            <th>Product Name</th>
            <th>Stock</th>
            <th>Price</th>
            <th>Expiration</th>
        </tr>

        <c:forEach var="item" items="${ prodList }">
            <tr>
                <td>
                    <c:out value="${ item.productId }"/>
                </td>
                <td>${item.productName}</td>
                <td><c:out value="${ item.stock }"/></td>
                <td><c:out value="${ item.price }"/></td>
                <td>${item.expiration}</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>