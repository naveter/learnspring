<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<body>

<p>m=${m}</p>
<p>c=${c}</p>

<div ng-app="myApp" ng-controller="customersCtrl">

    <ul>
        <li ng-repeat="x in myData">
            {{ x.lastname + ', ' + x.firstname }}
        </li>
    </ul>


</div>

<script>

</script>

<script src="js/main.js"></script>

</body>
</html>

