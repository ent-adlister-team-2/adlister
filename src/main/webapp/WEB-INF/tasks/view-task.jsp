<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Tasks"/>
    </jsp:include>
    <title>Viewing Task Details</title>
</head>
<body class="homepage-background">
<jsp:include page="../partials/navbar.jsp"/>
<div class="login-box">
    <div class="individual user-box">
        <h1 class="title">${task.getName()}</h1>
        <p class="homepage-text">${task.getDescription()}</p>
        <p class="homepage-text">${task.getRepeatable()}</p>
    </div>

    <button>
        <a href="/tasks/view/edit?id=${task.id}">Edit Task</a>
        <span></span>
    </button>
    <button>
        <a href="/tasks/view/delete?id=${task.id}">Delete Task</a>
        <span></span>
    </button>


</div>
</body>
</html>
