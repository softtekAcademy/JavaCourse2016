<%@ page language="java" contentType="application/json; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date" %>
<%@ page import="com.softtek.java.academy.web.lesson3.bean.ProductJSONBean" %>
<%!
    ProductJSONBean bean = new ProductJSONBean();
 %>
<% response.setContentType("application/json");

   bean.setProductId(1);
   bean.setProductName("Product 001");
   bean.setStock(850);
   bean.setPrice(450.99);
   bean.setExpiration(new Date());
 %>
<%=bean.toString()%>