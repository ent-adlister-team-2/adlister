<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp"/>
    <title>Title</title>
</head>
<body class="homepage-background">
<div class="page-wrapper">
    <jsp:include page="../partials/navbar.jsp"/>
    <c:set var="wrongPassword" value="${requestScope.wrongPassword}"/>
    <div class="container login-box">
        <h1 class="title">Edit Household Name</h1>
        <c:if test="${not empty wrongPassword}">
            <h2 style="color: white">Your password was incorrect!</h2>
        </c:if>
        <form id="changeNameForm" action="${pageContext.request.contextPath}/profile/change-name" method="POST">
            <div class="user-box">
                <label for="name"></label>
                <input id="name" name="name" class="form-control" type="text" placeholder="New Household Name">
            </div>
            <div class="user-box">
                <label for="password"></label>
                <input id="password" name="password" class="form-control" type="password" placeholder="Password">
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
<script src="../../js/name_validation.js"></script>
</body>
</html>