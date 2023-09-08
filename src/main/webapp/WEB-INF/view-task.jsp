<jsp:useBean id="title" scope="request" type=""/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Viewing Task Details</title>
</head>
<body>
<div class="container">
    <h1>Task Details</h1>
    <div class="viewbox">
        <div class="taskTitle">
            <%=%>>
        </div>
        <div class="taskDescription">
            ${description}
        </div>
        <div class="repeatable">
            Is/Is Not Repeatable
        </div>
    </div>

</div>
</body>
</html>
