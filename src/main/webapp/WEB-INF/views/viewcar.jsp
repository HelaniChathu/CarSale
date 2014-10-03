<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>View Car Details</title>

    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/cover.css" />" rel="stylesheet">
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
</head>
<body>
<%--<p>${msg}</p>--%>
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
                    <form role="form">
                        <div class="form-group">
                            <label>Car ID</label>
                            <p>${car.id}</p>
                        </div>
                        <div class="form-group">
                            <label>Car Name</label>
                            <p>${car.carName}</p>
                        </div>
                        <div class="form-group">
                            <label>Make</label>
                            <p>${car.make}</p>
                        </div>
                        <div class="form-group">
                            <label>Engine CC</label>
                            <p>${car.engineCC}</p>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<%--<script src="../../dist/js/bootstrap.min.js"></script>--%>
<script src="../../assets/js/docs.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
