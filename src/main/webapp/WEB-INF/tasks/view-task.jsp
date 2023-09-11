<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Tasks" />
    </jsp:include>
    <title>Viewing Task Details</title>
</head>
<body class="background">
<jsp:include page="../partials/navbar.jsp" />
<div class="container background">

    <c:choose>
        <c:when test="${task.getId() == sessionScope.taskId}">
            <div class = "individual">
            <h1>${task.getName()}</h1>
            <p>${task.getDescription()}</p>
            <p>${task.getRepeatable()}</p>
            </div>
            <form action="/task/edit" method="GET">
                <input name="edit" value="${task.getId()}" type="hidden">
                <button type="submit">Edit</button>
            </form>
            <form action="/tasks/delete" method="POST">
                <input name="delete" value="${task.getId()}" type="hidden">
                <button type="submit">Delete</button>
            </form>
        </c:when>
        <c:otherwise>
            <h1>${task.getName()}</h1>
            <p>${task.getDescription()}</p>
            <p>${task.getRepeatable()}</p>
            <p>${task.getStatus()}</p>
        </c:otherwise>
    </c:choose>


</div>
</body>
</html>
