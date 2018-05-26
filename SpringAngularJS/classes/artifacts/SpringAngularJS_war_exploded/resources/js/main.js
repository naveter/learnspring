var app = angular.module('myApp', []);
app.controller('customersCtrl', function($scope, $http) {

    $scope.getFirst = function() {
        $http.get("/rest/first").then(function (response) {
            $scope.myData = response.data;
        });

        var newScope = $scope.$new(true, $scope);
        // newScope = angular.merge(newScope, this.data[i]);
        // var html = $.load( "html/first.html" );
        var html;
        $.get("/html/first.html", function(response) {
            html = response;
        });
        var element = $('#content');
        element.append($compile(html)(newScope));

        // $( "#content" ).load( "/html/first.html" );
        // $( "#content" ).html('<div ng-include="\'html/first.html\'"></div>')

    }
    $scope.getSecond = function() {
        $( "#content" ).load( "/html/second.html" );
        $http.get("/rest/second").then(function (response) {
            $scope.myData = response.data;
        });
    }
    $scope.getIndex = function() {
        $( "#content" ).load( "/html/index.html" );
        $http.get("/rest/index").then(function (response) {
            $scope.myData = response.data;
        });
    }

});

