<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
  <jsp:include page="../partials/head.jsp" />
    <title>Title</title>
</head>
<body class="homepage-background">
<div class="page-wrapper">
  <jsp:include page="../partials/navbar.jsp"/>
  <c:set var="invalidPassword" value="${requestScope.invalidPassword}"/>
  <div class="container login-box">
    <h1 class="title">Change Password</h1>
    <c:if test="${not empty invalidPassword}">
    <h2 style="color: white">Password is incorrect!</h2>
    </c:if>
    <form id="change-household-form" action="${pageContext.request.contextPath}/profile/change-password" method="POST">
      <div class="user-box">
        <label for="old-password"></label>
        <input id="old-password" name="old-password" class="form-control" type="password" placeholder="Old Password">
      </div>
      <div class="user-box">
        <label for="new-password"></label>
        <input id="new-password" name="new-password" class="form-control" type="password" placeholder=" New Password">
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
<script src="../../js/password_validation.js"></script>
</body>
</html>
