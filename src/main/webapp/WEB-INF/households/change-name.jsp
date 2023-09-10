<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp" />
    <title>Title</title>
</head>
<body>
<div class="page-wrapper">
    <jsp:include page="../partials/navbar.jsp"/>
    <div class="container">
        <h1>Change Household Name</h1>
        <form action="${pageContext.request.contextPath}/profile/change-name" method="POST">
            <div class="form-group">
                <label for="username">Username</label>
                <input id="username" name="username" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input id="password" name="password" class="form-control" type="password">
            </div>
            <div class="form-group">
                <label for="confirm-password">Confirm Your Password</label>
                <input id="confirm-password" name="confirm-password" class="form-control" type="password">
            </div>
            <div class="form-group">
                <label for="name">New Household Name</label>
                <input id="name" name="name" class="form-control" type="text">
            </div>
            <input type="submit" class="btn btn-primary btn-block" value="Log In">
        </form>
    </div>

</div>

</body>
</html>