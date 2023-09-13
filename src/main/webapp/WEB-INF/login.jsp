<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Log In"/>
    </jsp:include>
</head>
<body class="homepage-background">
<div class="page-wrapper">
    <jsp:include page="/WEB-INF/partials/navbar.jsp"/>
    <div class="container">
        <div class="row">
            <div class="column">
                <div class="login-box">
                    <form action="${pageContext.request.contextPath}/login" method="POST">
                        <h1 class="title">Please Log In</h1>

                        <div class="user-box">
                            <label for="username"></label>
                            <input id="username" name="username" type="text" placeholder="Username">
                        </div>
                        <div class="user-box">
                            <label for="password"></label>
                            <input id="password" name="password" type="password" placeholder="Password">
                        </div>
                        <div class="column">
                            <button type="submit">
                                Submit
                                <span></span>
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
