<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Tasks" />
    </jsp:include>
    <title>Viewing Task Details</title>
</head>
<body class="background">
<jsp:include page="../partials/navbar.jsp" />
<div class="container background">
    <h1>Task Details</h1>
    <div class="viewbox">
        <div class="taskTitle">
            ${name}
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
