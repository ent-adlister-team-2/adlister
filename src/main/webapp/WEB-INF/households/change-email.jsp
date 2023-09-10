<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp" />
    <title>Title</title>
</head>
<body>
<div class="page-wrapper">
    <c:set var="emailNotAvailable" value="${requestScope.emailNotAvailable}"/>
    <jsp:include page="../partials/navbar.jsp"/>
    <div class="container">
        <h1>Change Email</h1>
        <form id="change-email-form" action="${pageContext.request.contextPath}/profile/change-email" method="POST">
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
                <label for="old-email">Old Email</label>
                <input id="old-email" name="old-email" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="new-email">New Email</label>
                <input id="new-email" name="new-email" class="form-control" type="text">
            </div>
            <c:if test="${requestScope.emailNotAvailable == true && requestScope.emailNotAvailable != null}">
                <div class="alert alert-danger">
                    The email you selected is not available! Please choose a different email.
                </div>
            </c:if>
            <input type="submit" class="btn btn-primary btn-block" id="submit-btn" value="Log In">
        </form>
    </div>

</div>

<script src="../../js/email_validation.js"></script>
</body>
</html>