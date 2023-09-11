<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads"/>
    </jsp:include>
</head>
<body class="homepage-background">
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<div class="page-wrapper">
    <div class="container ">

        <h1>Household Tasks</h1>
        <a href="${pageContext.request.contextPath}/tasks/create">
            <button>Create Task</button>
        </a>

        <div class="row">
            <c:forEach var="task" items="${tasks}">
                <div class="taskCard">
                    <h2 class="title"><a href="/view-task" ${task.name}></a></h2>
                    <div class="title"> ${task.description} </div>
                    <div class="title"> Repeatable: ${task.repeatable} </div>
                    <div class="title"> Status: ${task.status} </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>
