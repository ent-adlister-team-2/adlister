<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
  <jsp:include page="../partials/head.jsp"/>
  <title>Title</title>
</head>
<body class="homepage-background">
<div class="page-wrapper">
  <jsp:include page="../partials/navbar.jsp"/>
  <div class="container login-box">
    <h1 class="title">Edit Task</h1>
    <form action="/tasks/view/edit?id=${task.id}" method="POST">
      <div class="user-box">
        <label for="name"></label>
        <input id="name" name="name" class="form-control" type="text" placeholder="Task Name">
      </div>
      <div class="user-box">
        <label for="description"></label>
        <input id="description" name="description" class="form-control" type="text" placeholder="Task Description">
      </div>
      <div class="user-box">
        <label for="category"></label>
        <input id="category" name="category" class="form-control" type="text" placeholder="Task Category">
      </div>
<%--      <div class="user-box">--%>
<%--        <label for="completion-status"></label>--%>
<%--        <input id="completion-status" name="completion-status" class="form-control" type="checkbox" placeholder="Is this Task Complete?">--%>
<%--      </div>--%>
      <div class="user-box">
        <label for="repeatable"></label>
        <input id="repeatable" name="repeatable" class="form-control" type="checkbox" placeholder="Is this Task Repeatable?">
      </div>
      <button type="submit" class="submit-btn">Save Changes</button>
    </form>
  </div>

</div>

</body>
</html>