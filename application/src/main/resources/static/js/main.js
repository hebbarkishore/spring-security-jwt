var app = angular.module("EmployeeManagement", []);
 
// Controller Part
app.controller("EmployeeController", function($scope, $http) {
 
 
    $scope.employees = [];
    $scope.employeeForm = {
        id: 1,
        empNo: "",
        empName: ""
    };
    
    $scope.authReq={
    	userName: "user1@test.com",
        password: "testMe"
    }
    
    $scope.authResp={};
 
    // Now load the data from server
    _refreshEmployeeData();
 
    // HTTP POST/PUT methods for add/edit employee  
    // Call: http://localhost:8080/employee
    $scope.submitEmployee = function() {
        var method = "";
        var url = '/employees';
 
        if ($scope.employeeForm.id == -1) {
            method = "POST";
        } else {
            method = "PUT";
        }
 
        $http({
            method: method,
            url: url,
            data: angular.toJson($scope.employeeForm),
            headers: {
                'Content-Type': 'application/json',
                'Authorization': 'Bearer '+$scope.authResp.accessToken
            }
        }).then(_success, _error);
    };
 
    $scope.createEmployee = function() {
        _clearFormData();
    }
 
    // HTTP DELETE- delete employee by Id
    // Call: http://localhost:8080/employee/{id}
    $scope.deleteEmployee = function(employee) {
        $http({
            method: 'DELETE',
            url: '/employees/' + employee.id,
            headers: {
                'Authorization': 'Bearer '+$scope.authResp.accessToken
            }
        }).then(_success, _error);
    };
 
    // In case of edit
    $scope.editEmployee = function(employee) {
        $scope.employeeForm.id = employee.id;
        $scope.employeeForm.empNo = employee.empNo;
        $scope.employeeForm.empName = employee.empName;
    };
 
    // Private Method  
    // HTTP GET- get all employees collection
    // Call: http://localhost:8080/employees
    function _refreshEmployeeData() {
    	$http({
            method: 'POST',
            url: '/authenticate',
            data: angular.toJson($scope.authReq),
            headers: {
                'Content-Type': 'application/json'
            }            	
        }).then(
            function(res) { // success
                $scope.authResp = res.data;
                $http({
                    method: 'GET',
                    url: '/employees',
                	headers: {
                        'Authorization': 'Bearer '+$scope.authResp.accessToken
                    }
                }).then(
                    function(res) { // success
                        $scope.employees = res.data;
                    },
                    function(res) { // error
                        console.log("Error: " + res.status + " : " + res.data);
                    }
                );
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );    	        
    }
 
    function _success(res) {
        _refreshEmployeeData();
        _clearFormData();
    }
 
    function _error(res) {
        var data = res.data;
        var status = res.status;
        var header = res.header;
        var config = res.config;
        alert("Error: " + status + ":" + data);
    }
 
    // Clear the form
    function _clearFormData() {
        $scope.employeeForm.id = -1;
        $scope.employeeForm.empNo = "";
        $scope.employeeForm.empName = ""
    };
});