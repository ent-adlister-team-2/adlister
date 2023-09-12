<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Delete Task </title>
</head>
<body>
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
