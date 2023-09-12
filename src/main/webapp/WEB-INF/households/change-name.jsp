<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp"/>
    <title>Title</title>
</head>
<body class="homepage-background">
<div class="page-wrapper">
    <jsp:include page="../partials/navbar.jsp"/>
    <div class="container login-box">
        <h1 class="title">Edit Task</h1>
        <form id="change-household-form" action="${pageContext.request.contextPath}/profile/change-name" method="POST">
            <div class="user-box">
                <label for="password"></label>
                <input id="password" name="password" class="form-control" type="password" placeholder="Password">
            </div>
            <div class="user-box">
                <label for="name"></label>
                <input id="name" name="name" class="form-control" type="text" placeholder="New Household Name">
            </div>
            <div>
                <button type="submit">
                    Submit
                    <span></span>
                </button>
            </div>
        </form>
    </div>

</div>
<script src="../../js/name_validation.js"></script>
</body>
</html>