<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value=""/>
    </jsp:include>
</head>
<body class="homepage-background">
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<main class="container">
    <div class="row justify-center">
        <div class="column justify-center">

        </div>
        <div class="homepage-text">
            Lorem ipsum dolor sit amet, consectetur adipisicing elit. Architecto beatae blanditiis, deleniti dolore expedita fugiat ipsam iste minus mollitia nihil nobis odit tempora tempore vel voluptate? Eum reiciendis repellendus voluptatum!
        </div>
    </div>
    <div class="align-bottom nav-list">
        <h1>
            Creators:
            <ul class="title">
                <li>Ty    </li>
                <li>Audrey</li>
                <li>Kurt  </li>
            </ul>
        </h1>
    </div>
</main>
</body>
</html>
