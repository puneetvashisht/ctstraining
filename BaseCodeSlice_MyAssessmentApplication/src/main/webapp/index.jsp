<html>
<head>
    <title>Employee List</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.3.1/css/foundation.css">
    <style type="text/css">
    	h3{
    		text-align: center;
    	}
    	
    </style>
</head>
<body ng-app="myApp">

    <div ng-controller="EmpCtrl">
       
      <input type="text" ng-model="search.amount" placeholder="Search By Amount"/>
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
				<tr ng-repeat="increment in increments | filter : search">
					<td>{{$index + 1}}</td>
					<td><a ng-click="showRecords($index)">{{increment.employee.id}}</a></td>
					<td>{{increment.employee.name}}</td>
					<td>{{increment.employee.salary}}</td>
					<td>{{increment.amount}}</td>
				</tr>
			</tbody>

		</table>
		
		
		<table ng-show="show">
			<thead>
				<tr>
					<td>Key</td>
					<td>Value</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>EMPLOYEE_NAME</td>
					<td>{{detailIncrement.employee.name}}</td>
				</tr>
				<tr>
					<td>EMPLOYEE_SALARY</td>
					<td>{{detailIncrement.employee.salary}}</td>
				</tr>
				<tr>
					<td>AMOUNT</td>
					<td>{{detailIncrement.amount}}</td>
				</tr>
			</tbody>

		</table>

	</div>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
    <script>
        var app = angular.module("myApp", []);
        app.controller("EmpCtrl", function($scope, $http){
        	
        	$scope.show = false;
        	
        	$scope.showRecords = function(index){
        		$scope.detailIncrement = $scope.increments[index];
        		$scope.show = true;
        	}
        	$scope.$watch('search.amount', function(newValue, oldValue) {
        		  $scope.show = false;
        		});
			
        	$http({
                method: "GET",
                headers: {
            	   "Content-Type": "application/json"
            	 },
                url: "http://localhost:8080/BaseCodeSlice_MyAssessmentApplication/mvc/incrementList?id="+1
              })
              .then(res=>res.data)
              .then(data => {
              	console.log(data);
              	$scope.increments = data;
              })
           
        })
    </script>
</body>
</html>