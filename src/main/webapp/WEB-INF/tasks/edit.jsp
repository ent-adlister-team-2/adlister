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
    <form action="/tasks/view/edit?id=${task.id}" method="POST" id="editTask">
      <div class="user-box">
        <label for="name"></label>
        <input id="name" name="name" class="form-control" type="text" placeholder="Task Name" value="${task.name}">
      </div>
      <div class="user-box">
        <label for="description"></label>
        <input id="description" name="description" class="form-control" type="text" placeholder="Task Description" value="${task.description}">
      </div>
      <div class="repeat-check">
        <input id="repeatable" name="repeatable" class="form-control" type="checkbox">
        <label for="repeatable">Repeatable task?</label>
      </div>
      <button type="submit" class="submit-btn" >Save Changes <span></span></button>
    </form>
  </div>

</div>
<script src="../../js/edit_task_validation.js"></script>
</body>
</html>