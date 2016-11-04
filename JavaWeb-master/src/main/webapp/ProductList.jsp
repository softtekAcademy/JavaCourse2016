<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="com.softtek.java.academy.web.lesson2.bean.*"  
         import="com.softtek.java.academy.web.lesson3.dao.ProductDAO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Product List</title>
</head>
<body>
    <jsp:useBean id="dao" class="com.softtek.java.academy.web.lesson3.dao.ProductDAO"/>

    <p/>
    <table border="1">
        <tr>
            <th>Product ID</th>
            <th>Product Name</th>
            <th>Stock</th>
            <th>Price</th>
            <th>Expiration</th>
        </tr>
        <%! 
        ProductDAO dao = new ProductDAO();
        List<ProductBean> prodList = dao.getProductList();
         %>
        <%
        for(int i=0; i<prodList.size();i++){%>
            <tr>
                <td><%= ((ProductBean)prodList.get(i)).getProductId() %></td>
                <td><%= ((ProductBean)prodList.get(i)).getProductName() %></td>  
                <td><%= ((ProductBean)prodList.get(i)).getStock() %></td>
                <td><%= ((ProductBean)prodList.get(i)).getPrice() %></td>  
                <td><%= ((ProductBean)prodList.get(i)).getExpiration() %></td>  
            </tr>
      <%}%>
    </table>

</body>
</html>