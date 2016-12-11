<%@page import="com.softtek.academy.jstl.service.StatusService"%>
<%@page import="com.softtek.academy.jstl.service.ShipToService"%>
<%@page import="org.apache.commons.lang3.StringUtils"%>
<%@page import="com.softtek.academy.jstl.domain.model.Status"%>
<%@page import="com.softtek.academy.jstl.domain.model.ShipTo"%>
<%@page import="java.util.List"%>
<%@page import="com.softtek.academy.jstl.domain.model.Cart"%>
<%@page import="com.softtek.academy.jstl.service.CartService"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%!
	CartService cartService = new CartService();
	ShipToService shipToService = new ShipToService();
	StatusService statusServcie = new StatusService();
%>
<%
	String msg = "";

	// Find the original cart from de DataBase
	// --------------------------------------------------------------------------
	Cart cart = cartService.findOne(new Long(request.getParameter("cartId")));
	
	// Modify the original values only if users click the update button
	// --------------------------------------------------------------------------
	if (request.getParameter("update") != null) {
		
		final Long cartId = new Long(request.getParameter("cartId"));
		final Double linesAmount = 
				StringUtils.isNotEmpty(request.getParameter("linesAmount")) 
						? new Double(request.getParameter("linesAmount")) : null;
		final Double shippingAmount = 
				StringUtils.isNotEmpty(request.getParameter("shippingAmount")) 
						? new Double(request.getParameter("shippingAmount")) : null;
		final Double cartAmount = 
				StringUtils.isNotEmpty(request.getParameter("cartAmount")) 
						? new Double(request.getParameter("cartAmount")) : null;
		final Long shipToId = new Long(request.getParameter("shipToId"));
		final Long statusId = new Long(request.getParameter("statusId"));
		// createUser, createDate, updateUser and updateDate will be updated in cartService.update();
		
		cart.setId(cartId);
		cart.setLinesAmount(linesAmount);
		cart.setShippingAmount(shippingAmount);
		cart.setCartAmount(cartAmount);
		cart.setShipTo(new ShipTo(shipToId, StringUtils.EMPTY));
		cart.setStatus(new Status(statusId, StringUtils.EMPTY, StringUtils.EMPTY));
		
		Boolean cartUpdatd = cartService.update(cart);
		
		if (cartUpdatd) {
			// Successful update
			response.sendRedirect(request.getContextPath() + "/jsp/cart/list.jsp");
		}
		else {
			// Unsuccessful update
			msg = "Please check the required filds.";
		}
	}
	
	List<ShipTo> shipTos = shipToService.list();
	List<Status> cartStatus = statusServcie.getCartStatus();
	
	request.setAttribute("cart", cart);
	request.setAttribute("shipTos", shipTos);
	request.setAttribute("cartStatus", cartStatus);
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<title>States</title>
	<meta charset="UTF-8">
</head>
<body style="font-family: sans-serif;">
	<h3 style="color: blue; font-family: sans-serif;">New State</h3>
	
	<form action="" method="post">
		<table style="width: 80%;">
			<tr>
				<td width="13%">Id</td>
				<td width="25%">
					<input type="text" name="id" value="${cart.id}" readonly="readonly">
				</td>
				<td width="10%">Ship To:*</td>
				<td width="25%">
					<select name="shipToId">
						<option value="0">- Select -</option>
						<c:forEach var="shipTo" items="${shipTos}">
							<option value="${shipTo.id}" <c:if test="${shipTo.id==cart.shipTo.id}">selected</c:if>>${shipTo.name}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>Lines Amount:*</td>
				<td>
					<input type="text" name="linesAmount" value="${cart.linesAmount}">
				</td>
				<td>Status:*</td>
				<td>
					<select name="statusId">
						<option value="0">- Select -</option>
						<c:forEach var="status" items="${cartStatus}">
							<option value="${status.id}" <c:if test="${status.id==cart.status.id}">selected</c:if>>${status.description}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>Shipping Amount:*</td>
				<td>
					<input type="text" name="shippingAmount" value="${cart.shippingAmount}">
				</td>
				<td>Create Date</td>
				<td>
					<input type="text" name="createDate" value="${cart.createDate}" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td>Cart Amount</td>
				<td>
					<input type="text" name="cartAmount" value="${cart.cartAmount}">
				</td>
				<td>Update Date</td>
				<td>
					<input type="text" name="updateDate" value="${cart.updateDate}" readonly="readonly">
				</td>
			</tr>
		</table>
		
		<br>
		<input type="submit" name="update" value="Update">
	</form>
	
	<br>
	<div><%= msg %></div>
	
	<br>
	<a href="<c:url value="/jsp/cart/list.jsp"/>">Return to List</a>
</body>
</html>