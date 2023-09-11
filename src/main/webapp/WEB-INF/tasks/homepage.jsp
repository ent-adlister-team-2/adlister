<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body class="background">
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
    <h1>Household Tasks</h1>
    <a href="${pageContext.request.contextPath}/tasks/create"><button>Create Task</button></a>
    <div class="row ">
        <c:forEach var="task" items="${tasks}">
        <div class="taskCard">
            <h2> ${task.name} </h2>
            <div> ${task.description} </div>
            <div> Repeatable: ${task.repeatable} </div>
            <div> Status: ${task.status} </div>
            <a href="${pageContext.request.contextPath}/tasks/view?id=${task.id}">View Task Details</a>
        </div>
        </c:forEach>

</body>
</html>
