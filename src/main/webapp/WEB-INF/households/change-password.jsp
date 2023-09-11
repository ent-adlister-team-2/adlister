<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <jsp:include page="../partials/head.jsp" />
    <title>Title</title>
</head>
<body class="homepage-background">
<div class="page-wrapper">
  <jsp:include page="../partials/navbar.jsp"/>
  <div class="container login-box">
    <h1 class="title">Change Password</h1>
    <form action="${pageContext.request.contextPath}/profile/change-password" method="POST">
      <div class="user-box">
        <label for="username"></label>
        <input id="username" name="username" class="form-control" type="text" placeholder="Username">
      </div>
      <div class="user-box">
        <label for="old-password"></label>
        <input id="old-password" name="old-password" class="form-control" type="password" placeholder="Old Password">
      </div>
      <div class="user-box">
        <label for="new-password"></label>
        <input id="new-password" name="new-password" class="form-control" type="password" placeholder=" New Password">
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

</body>
</html>
