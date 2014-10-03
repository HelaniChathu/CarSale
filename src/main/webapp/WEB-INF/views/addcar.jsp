<%--&lt;%&ndash;--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--we can call this uri by assigning "c" & later use this "c" to give the path to a css,js....etc--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%--&lt;%&ndash;--%>
  <%--Created by IntelliJ IDEA.--%>
  <%--User: helani--%>
  <%--Date: 10/1/14--%>
  <%--Time: 10:22 AM--%>

<%--<!DOCTYPE html>--%>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <%--<link rel="icon" href="../../favicon.ico">--%>

    <title>Add Car Details</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <%--<link href="../../dist/css/bootstrap.min.css" rel="stylesheet">--%>

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/cover.css" />" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<%--<h2>${msg}</h2>--%>
<div class="site-wrapper">

    <div class="site-wrapper-inner">

        <div class="cover-container">

            <div class="masthead clearfix">
                <div class="inner cover">
                    <h1 class="cover-heading">Add Car Details</h1>
                </div>
            </div>

        <div>
            <div class="inner cover">
                <form:form role="form" commandName="car" method="POST" action="addCar">
                    <div class="form-group">
                        <form:label path="carName">Car Name</form:label>
                        <form:input type="text" class="form-control" path="carName" />
                    </div>
                    <div class="form-group">
                        <form:label path="make">Make</form:label>
                        <form:input type="text" class="form-control" path="make" />
                    </div>
                    <div class="form-group">
                        <form:label path="engineCC">Engine CC</form:label>
                        <form:input type="number" class="form-control" path="engineCC" />
                    </div>
                    <div>
                        <button type="submit" class="btn btn-default">Submit</button>
                    </div>

                </form:form>
            </div>
        </div>

            <div class="mastfoot">
                <div class="inner">
                    <p>CarSale AutoLanka@com.</p>
                </div>
            </div>

        </div>

    </div>

</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<%--<script src="../../dist/js/bootstrap.min.js"></script>--%>
<script src="../../assets/js/docs.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>

