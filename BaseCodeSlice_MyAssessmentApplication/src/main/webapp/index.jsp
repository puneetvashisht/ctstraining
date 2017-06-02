<html>
<head>
    <title>Employee List</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.3.1/css/foundation.css">
    <style type="text/css">
    	h3{
    		text-align: center;
    	}
    	table{
    		outline: #00FF00 dotted thick;
    	}
    </style>
</head>
<body ng-app="myApp">
    <div ng-controller="EmpCtrl">
       
      <input type="text" ng-model="search.name" placeholder="Search By Name"/>
       <hr/>
		<h3>Employee Table</h3>
        <table>
            <tr ng-repeat="employee in employees | filter: search" ng-click="getEmpIncrements(employee.id)">
                <td>{{$index + 1}}</td>
                <td>{{employee.name}}</td>
                <td>{{employee.salary}}</td>
            </tr>
        </table>
        <hr/>
        
        
		<h3>Employee Increments Table</h3>
                <table>
                <thead>
                	<tr>
                		                	<td>S.No.</td>
                	<td>EmpId</td>
                	<td>EmpName</td>
                	<td>EmpSalary</td>
                	<td>SalaryIncrement</td>
                		
                	</tr>
                </thead>
                <tbody>
            <tr ng-repeat="increment in increments">
                <td>{{$index + 1}}</td>
                <td>{{increment.employee.id}}</td>
                <td>{{increment.employee.name}}</td>
                <td>{{increment.employee.salary}}</td>
                <td>{{increment.amount}}</td>
            </tr>
            </tbody>
        </table>
        
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
    <script>
        var app = angular.module("myApp", []);
        app.controller("EmpCtrl", function($scope, $http){
			$scope.getEmpIncrements = function(empId){
				console.log("clicked me ",empId);
	            $http({
	                method: "GET",
	                headers: {
                	   "Content-Type": "application/json"
                	 },
	                url: "http://localhost:8080/BaseCodeSlice_MyAssessmentApplication/mvc/incrementList?id="+empId
	              })
	              .then(res=>res.data)
	              .then(data => {
	              	console.log(data);
	              	$scope.increments = data;
	              })

			}

            $http({
              method: 'GET',
              headers: {
           	   "Content-Type": "application/json"
           	 },
              url: "http://localhost:8080/BaseCodeSlice_MyAssessmentApplication/mvc/employees?name=ramesh"
            }).then(res=>res.data)
            .then(data => {
            	console.log(data);
            	$scope.employees = data;
            })
           
        })
    </script>
</body>
</html>