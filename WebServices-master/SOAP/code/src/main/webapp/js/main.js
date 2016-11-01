var app = angular.module('SoapApp', []);

app.controller('MainCtrl', function($scope, $http, $q) {
	
	$scope.init = function() {
		$scope.accountNumber = "";
		$scope.password = "";
		$scope.option = "accountDetails";
	}
	
	$scope.sendRequest = function(contextPath) {
		$scope.soapRequest =
			'<?xml version="1.0" encoding="utf-8"?>' +
			'<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:bank="http://www.academy-softtek.com/soap/bank">' +
			   '<soapenv:Header/>' +
			   '<soapenv:Body>' +
			      '<bank:accountDetailsRequest>' +
			         '<accountNumber>' + $scope.accountNumber + '</accountNumber>' +
			         '<password>'+$scope.password+'</password>' +
			      '</bank:accountDetailsRequest>' +
			   '</soapenv:Body>' +
			'</soapenv:Envelope>';
		
		$scope.soapCall(contextPath);
	}
	
	$scope.addNew = function(contextPath) {
		$scope.soapRequest = 
			'<?xml version="1.0" encoding="utf-8"?>' +
			'<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:bank="http://www.academy-softtek.com/soap/bank">' +
			   '<soapenv:Header/>' +
			   '<soapenv:Body>' +
			      '<bank:addNewAccountRequest>' +
			         '<accountNumber>' + $scope.accountNumber + '</accountNumber>' +
			         '<ownerFirstName>' + $scope.firstName + '</ownerFirstName>' +
			         '<ownerLastName>' + $scope.lastName + '</ownerLastName>' +
			         '<password>' + $scope.password + '</password>' +
			         '<amount>' + $scope.amount + '</amount>' +
			      '</bank:addNewAccountRequest>' +
			   '</soapenv:Body>' +
			'</soapenv:Envelope>';
		
		$scope.soapCall(contextPath);
	}
	
	$scope.soapCall = function(contextPath) {
		$http({
			method: 'POST',
			url: contextPath+"/ws/BankService",
			data: $scope.soapRequest,
			headers: {
				"Content-Type": 'text/xml; charset=UTF-8'
			}
		}).then(function(response) {
			$scope.response = formatXml(response.data);
		},
		function(response) {
			$scope.response = response.data;
		});
	}
	
	$scope.change = function() {
		$scope.accountNumber = "";
		$scope.password = "";
		$scope.firstName = "";
		$scope.lastName = "";
		$scope.amount = "";
		$scope.response = "";
	}

});