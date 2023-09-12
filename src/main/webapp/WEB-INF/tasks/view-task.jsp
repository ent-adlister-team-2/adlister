<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Tasks"/>
    </jsp:include>
    <title>Viewing Task Details</title>
</head>
<body class="background">
<jsp:include page="../partials/navbar.jsp"/>
<div class="container background">
    <div class="individual">
        <h1>${task.getName()}</h1>
        <p>${task.getDescription()}</p>
        <p>${task.getRepeatable()}</p>
    </div>

    <a href="/tasks/view/edit?id=${task.id}">Edit Task</a>
    <a href="/tasks/view/delete?id=${task.id}">Delete Task</a>

</div>
</body>
</html>
