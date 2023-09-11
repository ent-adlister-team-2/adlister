<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Log In"/>
    </jsp:include>
</head>
<body class="background">
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<div class="container">

    <div class="login-box">
        <form action="/login" method="POST">
            <h1 class="title">Please Log In</h1>

            <div class="user-box">
                <label for="username"></label>
                <input id="username" name="username" class="form-control" type="text" placeholder="Username">
            </div>
            <div class="user-box">
                <label for="password"></label>
                <input id="password" name="password" class="form-control" type="password" placeholder="Password">
            </div>
            <center>
                <a href="">
                    <input class="submit-btn" type="submit">
                    Submit
                    <span></span>
                </a></center>
        </form>
    </div>
</div>
</body>
</html>
