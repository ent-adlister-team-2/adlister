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
                <input id="username" name="username" type="text" placeholder="Username">
            </div>
            <div class="user-box">
                <label for="password"></label>
                <input id="password" name="password" type="password" placeholder="Password">
            </div>
            <center>
                <a href="" class="text-center">
                    <input class="submit-btn" type="submit">
                    Submit
                    <span></span>
                </a></center>
        </form>
    </div>
</div>
</body>
</html>
