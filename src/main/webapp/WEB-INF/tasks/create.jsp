<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad"/>
    </jsp:include>
</head>
<body class="homepage-background">
<div class="container login-box">
    <h1 class="title">Create a new Task</h1>
    <form action="${pageContext.request.contextPath}/tasks/create" method="post" class="column">
        <div class="user-box">
            <label for="name"></label>
            <input id="name" name="name" class="form-control" type="text" placeholder="Title">
        </div>
        <div class="user-box">
            <label for="description"></label>
            <input id="description" name="description" class="form-control" type="text" placeholder="Description">
        </div>
        <div class="column margin-top-2">
            <label class="title">
                <input type="checkbox" id="repeatable" name="repeatable" value="repeatable"
                       checked="checked"/> Is this task repeatable?
            </label>
        </div>
        <div class="column">
            <button type="submit">
                Submit
                <span></span>
            </button>
        </div>
    </form>
</div>
</body>
</html>
