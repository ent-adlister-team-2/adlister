<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <div class="tasks row d-flex">
        <c:forEach var="task" items="${tasks}">
            <div class="card">
                <div class="content">
                    <h2 class="heading">Task: ${task.name} </h2>
                    <div class="para">Description: ${task.description} </div>
                    <div> Repeatable: ${task.repeatable} </div>
                    <div> Status: ${task.status} </div>
                    <button class="task-btn">
                        <span class="task-btn-text-one">Nice!</span>
                        <span class="task-btn-text-two">Add Back To List!</span>
                    </button>
                    <button class="btn" type="submit">
                        <a href="${pageContext.request.contextPath}/tasks/view?id=${task.id}">View Task Details</a>
                    </button>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
