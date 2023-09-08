<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
    <h1>Household Tasks</h1>
    <a href="/"><button>Create Task</button></a>
    <div class="row">
        <c:forEach var="task" items="${tasks}">
        <div class="taskCard">
            <h2> ${task.name} </h2>
            <div> ${task.description} </div>
            <div> Repeatable: ${task.repeatable} </div>
            <div> Status: ${task.status} </div>
        </div>
        </c:forEach>

</body>
</html>
