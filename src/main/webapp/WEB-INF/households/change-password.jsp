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
    <h1>Change Password</h1>
    <form action="${pageContext.request.contextPath}/profile/change-password" method="POST">
      <div class="form-group">
        <label for="username">Username</label>
        <input id="username" name="username" class="form-control" type="text">
      </div>
      <div class="form-group">
        <label for="old-password">Old Password</label>
        <input id="old-password" name="old-password" class="form-control" type="password">
      </div>
      <div class="form-group">
        <label for="new-password">New Password</label>
        <input id="new-password" name="new-password" class="form-control" type="password">
      </div>
      <input type="submit" class="btn btn-primary btn-block" value="Log In">
    </form>
  </div>

</div>

</body>
</html>
