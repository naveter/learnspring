var app = angular.module('myApp', []);
app.controller('customersCtrl', function($scope, $http) {
    $http.get("rest/first").then(function (response) {
        $scope.myData = response.data;
    });
});



