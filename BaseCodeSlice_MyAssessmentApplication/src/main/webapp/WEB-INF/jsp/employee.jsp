<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<title>Registration Page</title>
 <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" />
<style>
	.cssClass {
		background-color: red;
	}
</style>

</head>
<body ng-app="myApp">

<h2>

<p>Current Locale : ${pageContext.response.locale} </p>
welcome.springmvc : <spring:message code="welcome.springmvc"/>
welcome.springmvc : <spring:message code="label.firstname"/>
</h2>

<form:form method="POST" commandName="employee" modelAttribute="employee" name="userForm">
<table>
    <tr>
    
    	 <div class="form-group" ng-class="{ 'has-error' : userForm.name.$invalid && !userForm.name.$pristine }">
    	
        <td>User Name :</td>
        <td><form:input path="name" ng-model="name" required="true" /> <span ng-show="userForm.name.$invalid && !userForm.name.$pristine" class="help-block">You name is required.</span></td> 
        <td><form:errors path="name" cssClass="error" /></td>
        </div>
    </tr>
    <tr>
        <td>Salary :</td>
        <td><form:input path="salary" ng-model="salary" type="number" /></td>
        <td><form:errors path="salary" cssClass="error" /></td>
    </tr>
    
    <tr>
        <td colspan="2"><input type="submit" value="Add" ng-disabled="userForm.$invalid"></td>
    </tr>
</table>
</form:form>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<script>
	var app = angular.module('myApp', []);
	
	app.controller('AppCtrl', function($scope){
		$scope.name = "";
		$scope.salary = "";
	})

</script>

</body>
</html>