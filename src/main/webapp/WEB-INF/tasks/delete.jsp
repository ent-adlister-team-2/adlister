<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Delete Task </title>
</head>
<body>
<form method="POST" action="/tasks/delete?id=${task.id}">
    <div class="taskCard">
        <h2> ${task.name} </h2>
        <div> ${task.description} </div>
        <div> Repeatable: ${task.repeatable} </div>
        <div> Status: ${task.status} </div>
    </div>
    <button type="submit">Delete Task</button>
</form>

</body>
</html>
