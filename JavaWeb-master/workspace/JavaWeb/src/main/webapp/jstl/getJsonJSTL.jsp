<%@page language="java" contentType="application/json;charset=UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>


    <json:object>
      <json:property name="userId" value="001"/>
      <json:property name="userName" value="Juan Perez"/>
      <json:array name="departmentList" items="uno,dos"/>
    </json:object>
    <c:remove var="items" scope="page"/>