<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/main.css" />
    <script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
    <script>
        $(function() {
            $("#jqCheck").text("jquery is work");
        });
    </script>
</head>
<body>

<p>m=${m}, c=${c} and <span id="jqCheck">***</span></p>

<div ng-app="myApp" ng-controller="customersCtrl">

    <p id="header">
        <div><a href="#" ng-click="getIndex()">Get Index</a></div>
        <div><a href="#" ng-click="getFirst()">Get First</a></div>
        <div><a href="#" ng-click="getSecond()">Get Second</a></div>
    </p>

    <p id="sidebar">
        <ul>
            <li ng-repeat="x in myData">
                {{ x.lastname + ', ' + x.firstname }}
            </li>
        </ul>
    </p>

    <p id="content">


    </p>

    <div ng-include="'html/footer.html'"></div>


</div>




<script src="/js/main.js"></script>

</body>
</html>

