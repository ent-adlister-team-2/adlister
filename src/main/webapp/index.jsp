<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value=""/>
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<main class="container background">
    <div class="row header justify-center">
        <div class="column justify-center">
            image
        </div>
        <div class="column justify-center">
            Lorem ipsum dolor sit amet, consectetur adipisicing elit. Architecto beatae blanditiis, deleniti dolore expedita fugiat ipsam iste minus mollitia nihil nobis odit tempora tempore vel voluptate? Eum reiciendis repellendus voluptatum!
        </div>
    </div>
    <div class="row nav-list">
        <h4>
            Creators:
            <ul class="navbar">
                <li class="">Ty</li>
                <li class="">Audrey</li>
                <li class="">Kurt</li>
            </ul>
        </h4>
    </div>
</main>
</body>
</html>
