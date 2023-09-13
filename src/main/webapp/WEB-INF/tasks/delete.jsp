<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Delete Task </title>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Delete Task"/>
    </jsp:include>
</head>
<body class="homepage-background">
<jsp:include page="../partials/navbar.jsp"/>
<div class="container login-box">

    <form method="POST" action="${pageContext.request.contextPath}/tasks/view/delete?id=${task.id}">
        <div class="user-box">
            <h1 class="title">Task: ${task.getName()}</h1>
            <p class="homepage-text">Description: ${task.getDescription()}</p>
            <p class="homepage-text">Repeatable: ${task.getRepeatable()}</p>
        </div>
        <div class="column">
            <button type="submit" class="title">
                Delete Task
                <span></span>
            </button>
        </div>
    </form>
</div>
</body>
</html>
