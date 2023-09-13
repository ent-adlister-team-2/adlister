<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <jsp:include page="../partials/head.jsp" />
    <title>Title</title>
</head>
<body class="homepage-background">
<div class="page-wrapper">
    <c:set var="usernameNotAvailable" value="${requestScope.usernameNotAvailable}"/>
    <jsp:include page="../partials/navbar.jsp"/>
    <div class="container login-box">
        <h1 class="title">Change Username</h1>
        <c:if test="${not empty usernameNotAvailable}">
            <h2 style="color: white">Username not available.</h2>
        </c:if>
        <form id="change-household-form" action="${pageContext.request.contextPath}/profile/change-username" method="POST">
            <div class="user-box">
                <label for="old-username"></label>
                <input id="old-username" name="old-username" class="form-control" type="text" placeholder="Old Username">
            </div>
            <div class="user-box">
                <label for="new-username"></label>
                <input id="new-username" name="new-username" class="form-control" type="text" placeholder="New Username">
            </div>
            <div class="user-box">
                <label for="password"></label>
                <input id="password" name="password" class="form-control" type="password" placeholder="Password">
            </div>
            <div>
                <button type="submit">
                    Submit
                    <span></span>
                </button>
            </div>
        </form>
    </div>

</div>
<script src="../../js/username_validation.js"></script>
</body>
</html>

