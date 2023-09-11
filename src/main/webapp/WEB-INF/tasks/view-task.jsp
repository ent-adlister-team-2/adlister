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
            <div class = "individual">
            <h1>${task.getName()}</h1>
            <p>${task.getDescription()}</p>
            <p>${task.getRepeatable()}</p>
            </div>
<%--            <form action="/tasks/view/edit" method="get">--%>
<%--                <input name="edit" value="${task.id}" type="submit">--%>
<%--                <button type="submit">Edit</button>--%>
<%--            </form>--%>
            <a href="/tasks/view/edit?id=${task.id}">Edit Task</a>
            <form action="/tasks/delete" method="POST">
                <input name="delete" value="${task.id}" type="submit">
                <button type="submit">Delete</button>
            </form>
</div>
</body>
</html>
