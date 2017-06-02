<html>
<head>
    <title>Employee List</title>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/foundation/6.3.1/css/foundation.css">
</head>
<body ng-app="myApp">
    <div ng-controller="EmpCtrl">
       
      <input type="text" ng-model="search.name" placeholder="Search By Name"/>
       <hr/>

        <table>
            <tr ng-repeat="employee in employees | filter: search">
                <td>{{$index + 1}}</td>
                <td>{{employee.name}}</td>
                <td>{{employee.salary}}</td>
            </tr>
        </table>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
    <script>
        var app = angular.module('myApp', []);
        app.controller('EmpCtrl', function($scope, $http){
            $http({
              method: 'GET',
              url: 'http://localhost:8080/BaseCodeSlice_BankManagementSystem/mvc/employees?name=FromRequest'
            }).then(res=>res.data)
            .then(data => {
            	console.log(data);
            	$scope.employees = data;
            })
        

           
        })
    </script>
</body>
</html>