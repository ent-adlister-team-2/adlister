<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Delete Task </title>
</head>
<body>
<div class="taskCard">
    <h2> ${task.name} </h2>
    <div> ${task.description} </div>
    <div> Repeatable: ${task.repeatable} </div>
    <div> Status: ${task.status} </div>
</div>
</body>
</html>
