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
<c:set var="complete" value="${requestScope.complete}"/>
<c:set var="incomplete" value="${requestScope.incomplete}"/>
<div class="page-wrapper">
    <div class="container">
        <h1 class="household-name">${household.name}</h1>
        <h1 class="household-name">Household Tasks</h1>
    </div>
    <div class="create-sort container d-flex">
        <div class="create-button">
            <button class="btn margin-top-btn">
                <a href="${pageContext.request.contextPath}/tasks/create">
                    + Create New Task
                </a>
            </button>
        </div>
        <div class="sort-button">
            <form action="${pageContext.request.contextPath}/tasks/sort" method="get">
                <button class="btn margin-top-btn" type="submit" name="sort">Sort Alphabetical</button>
            </form>
        </div>
    </div>

    <div class="container">
        <div class="tasks row d-flex">
            <c:forEach var="task" items="${tasks}">
                <div class="card">
                    <div class="content">
                        <h2 class="heading">Task: ${task.name} </h2>
                        <div class="para">Description: ${task.description} </div>
                        <div> Repeatable: ${task.repeatable} </div>
                        <div> Status: ${task.status} </div>
                        <form action="/tasks/completed" method="get" id="completeTask" name="incomplete" >
                            <button class="task-btn"   type="submit">
                                <c:if test="${not empty complete}">
                                    <span class="task-btn-text-one">Complete Task</span>
                                    <span class="task-btn-text-two">Completed!</span>
                                </c:if>
                                <c:if test="${not empty complete}">
                                    <span class="task-btn-text-one">Incomplete Task</span>
                                    <span class="task-btn-text-two">Complete!</span>
                                </c:if>
                            </button>
                        </form>
                        <button class="btn margin-top-1" type="submit">
                            <a href="${pageContext.request.contextPath}/tasks/view?id=${task.id}">View Task
                                Details</a>
                        </button>

                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
<script>
    let completedTask = document.getElementById("completeTask");
    completedTask.addEventListener("submit", () => {
        console.log("button is clicked!");
        if (document.getElementsByName("incomplete")) {
            document.getElementById("completeTask").setAttribute("name", "complete");
        }
        if (document.getElementsByName("complete")) {
            document.getElementById("completeTask").setAttribute("name", "incomplete");
        }
    })
</script>
</body>
</html>
