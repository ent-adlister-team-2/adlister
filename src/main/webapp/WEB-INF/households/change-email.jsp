<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp"/>
    <title>Title</title>
</head>
<body class="homepage-background">
<div class="page-wrapper">
    <c:set var="emailNotAvailable" value="${requestScope.emailNotAvailable}"/>
    <c:set var="invalidEmail" value="${requestScope.invalidEmail}"/>
    <c:set var="invalidPassword" value="${requestScope.invalidPassword}"/>
    <jsp:include page="../partials/navbar.jsp"/>
    <div class="container login-box">
        <h1 class="title">Change Email</h1>
        <c:if test="${not empty emailNotAvailable}">
            <h2 style="color: white">Email not available.</h2>
        </c:if>
        <form id="changeEmailForm" action="${pageContext.request.contextPath}/profile/change-email" method="POST">
            <c:if test="${not empty invalidPassword}">
                <h2 style="color: white">Your password was incorrect!</h2>
            </c:if>
            <div class="user-box">
                <label for="password"></label>
                <input id="password" name="password" class="form-control" type="password" placeholder="Password">
            </div>
            <c:if test="${not empty invalidEmail}">
                <h2 style="color: white">Your email was incorrect!</h2>
            </c:if>
            <div class="user-box">
                <label for="oldEmail"></label>
                <input id="oldEmail" name="old-email" class="form-control" type="text" placeholder="Old Email">
            </div>
            <div class="user-box">
                <label for="newEmail"></label>
                <input id="newEmail" name="new-email" class="form-control" type="text" placeholder="New Email">
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
<script src="../../js/email_validation.js"></script>
</body>
</html>