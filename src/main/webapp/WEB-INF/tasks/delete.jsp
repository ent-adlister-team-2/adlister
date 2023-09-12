<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Delete Task </title>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Delete Task"/>
    </jsp:include>
</head>
<body>
<jsp:include page="../partials/navbar.jsp"/>
<form method="POST" action="/tasks/view/delete?id=${task.id}">
    <div class="taskCard">
        <h1>${task.getName()}</h1>
        <p>${task.getDescription()}</p>
        <p>${task.getRepeatable()}</p>
    </div>
    <button type="submit">Delete Task</button>
</form>

</body>
</html>
