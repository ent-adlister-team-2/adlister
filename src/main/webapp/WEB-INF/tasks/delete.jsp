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

</div>
<form method="POST" action="/tasks/view/delete?id=${task.id}" class="column ">
    <div class="user-box">
        <h1 class="title">${task.getName()}</h1>
        <p class="homepage-text">${task.getDescription()}</p>
        <p class="homepage-text">${task.getRepeatable()}</p>
    </div>
    <div class="column">
        <button type="submit" class="title">
            Delete Task
            <span></span>
        </button>
    </div>
</form>

</body>
</html>
