<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp"/>
    <title>Delete household</title>
</head>
<body class="background">
<div class="page-wrapper">
    <jsp:include page="../partials/navbar.jsp"/>
    <div class="container login-box">
        <h1 class="title">Are you sure you would like to Delete your Household?</h1>
        <form action="${pageContext.request.contextPath}/profile/delete" method="POST">
            <div class="user-box">
                <label for="username"></label>
                <input id="username" name="username" class="form-control" type="text" placeholder="Username">
            </div>
            <div class="user-box">
                <label for="password"></label>
                <input id="password" name="password" class="form-control" type="password" placeholder="Password">
            </div>
            <div class="user-box">
                <label for="confirm-password"></label>
                <input id="confirm-password" name="confirm-password" class="form-control" type="password" placeholder="Confirm Your Password">
            </div>
            <div class="user-box">
                <label for="user-confirm"></label>
                <input id="user-confirm" name="user-confirm" class="form-control" type="text"  placeholder="Enter user to Delete :${household.username}">
            </div>
            <a href="" class="text-center">
                <input class="submit-btn" type="submit">
                Submit
                <span></span>
            </a>
        </form>
    </div>

</div>

</body>
</html>