<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en" data-ng-app="SoapApp">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>SOAP Web Services</title>

    <link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/css/main.css" rel="stylesheet">

  </head>
  <body>
    <div class="panel panel-default margin-left-10 margin-right-10" data-ng-controller="MainCtrl" data-ng-init="init()" data-ng-cloak>
		<div class="panel-heading"><h1>SOAP Web Services</h1></div>
		<div class="panel-body">
			<div class="row">
				<a class="btn btn-default margin-left-10" href="<%=request.getContextPath()%>/ws/bank.wsdl" target="_blank"><span class="glyphicon glyphicon-file"></span> See WSDL</a>
				<hr>
			</div>
			<div class="row">
				<div class="form-inline form-group">
					<label for="option">Select operation: </label>
					<select class="form-control" id="option" data-ng-model="option" data-ng-change="change()">
						<option value="accountDetails">Account Details</option>
						<option value="addNewAccount">Add New Account</option>
					</select>
				</div>
			</div>
			<div class="row" data-ng-show="option=='accountDetails'">
				<div class="col-md-12">
					<form class="form-inline">
						<div>
							<div class="form-group">
								<label for="accountNumber">Account Number: </label>
								<input type="text" class="form-control" id="accountNumber" 
								placeholder="Account Number" data-ng-model="accountNumber">
							</div>
							<div class="form-group">
								<label for=password>Password: </label>
								<input type="password" class="form-control" id="password" 
								placeholder="Password" data-ng-model="password">
							</div>
							<div class="form-group">
								<button class="btn btn-primary" data-ng-click="sendRequest('<%=request.getContextPath()%>')">Send Request</button>
							</div>
						</div>
						<div><var>Try Account Number = 030889, Password = abc</var></div>
					</form>
				</div>
			</div>
			<div class="row" data-ng-show="option=='addNewAccount'">
				<div class="col-md-12">
					<form class="form-inline">
						<div class="form-group">
							<label for="accountNumber">Account Number: </label>
								<input type="text" class="form-control" id="accountNumber" 
								placeholder="Account Number" data-ng-model="accountNumber">
						</div>
						<div class="form-group">
							<label for="firstName">First Name: </label>
								<input type="text" class="form-control" id="firstName" 
								placeholder="First Name" data-ng-model="firstName">
						</div>
						<div class="form-group">
							<label for="lastName">Last Name: </label>
								<input type="text" class="form-control" id="lastName" 
								placeholder="Last Name" data-ng-model="lastName">
						</div>
						<div class="form-group">
							<label for="password">Password: </label>
								<input type="text" class="form-control" id="password" 
								placeholder="Password" data-ng-model="password">
						</div>
						<div class="form-group">
							<label for="amount">Amount: </label>
								<input type="text" class="form-control" id="amount" 
								placeholder="Amount" data-ng-model="amount">
						</div>
						<div class="form-group">
							<button class="btn btn-primary" data-ng-click="addNew('<%=request.getContextPath()%>')">Send Request</button>
						</div>
					</form>
				</div>
			</div>
			<div class="row margin-top-15">
				<div class="col-md-6" data-ng-show="option=='accountDetails'">
				<span class="label label-primary">Request:</span>
<pre>&lt;?xml version="1.0" encoding="utf-8"?&gt;
&lt;soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:bank="http://www.academy-softtek.com/soap/bank"&gt;
   &lt;soapenv:Header/&gt;
   &lt;soapenv:Body&gt;
      &lt;bank:accountDetailsRequest&gt;
         &lt;accountNumber&gt;<code class="highlighted-red">{{accountNumber}}</code>&lt;/accountNumber&gt;
         &lt;password&gt;<code class="highlighted-red">{{password}}</code>&lt;/password&gt;
      &lt;/bank:accountDetailsRequest&gt;
   &lt;/soapenv:Body&gt;
&lt;/soapenv:Envelope&gt;</pre>
				</div>
				<div class="col-md-6" data-ng-show="option=='addNewAccount'">
					<span class="label label-primary">Request:</span>
<pre>&lt;?xml version="1.0" encoding="utf-8"?&gt;
&lt;soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:bank="http://www.academy-softtek.com/soap/bank"&gt;
   &lt;soapenv:Header/&gt;
   &lt;soapenv:Body&gt;
      &lt;bank:addNewAccountRequest&gt;
         &lt;accountNumber&gt;<code class="highlighted-red">{{accountNumber}}</code>&lt;/accountNumber&gt;
         &lt;ownerFirstName&gt;<code class="highlighted-red">{{firstName}}</code>&lt;/ownerFirstName&gt;
         &lt;ownerLastName&gt;<code class="highlighted-red">{{lastName}}</code>&lt;/ownerLastName&gt;
         &lt;password&gt;<code class="highlighted-red">{{password}}</code>&lt;/password&gt;
         &lt;amount&gt;<code class="highlighted-red">{{amount}}</code>&lt;/amount&gt;
      &lt;/bank:addNewAccountRequest&gt;
   &lt;/soapenv:Body&gt;
&lt;/soapenv:Envelope&gt;</pre>
				</div>
				<div class="col-md-6">
					<span class="label label-primary">Response:</span>
					<pre>{{response}}</pre>
				</div>
			</div>
		</div>
	</div>    
    
    <script src="<%=request.getContextPath()%>/js/jquery-1.11.3.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/formatXML.js"></script>
    <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/angular-1.2.29.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/main.js"></script>
  </body>
</html>