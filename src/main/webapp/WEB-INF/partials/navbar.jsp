<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <a class="row" href="/tasks">Tasklister</a>
</div>

<ul class="navbar ">
    <c:choose>
        <c:when test="${not loggedIn}">
            <c:choose>
                <c:when test="${pageContext.request.requestURI != '/signup'}">
                    <li class="nav-list li"><a href="/login">Login</a></li>
                </c:when>
                <c:otherwise>
                    <!-- This will be empty when on the signup page -->
                </c:otherwise>
            </c:choose>
            <li class="nav-list li"><a href="/register">Sign Up</a></li>
        </c:when>
        <c:otherwise>
            <li class="nav-list li"><a href="/logout">Logout</a></li>
        </c:otherwise>
    </c:choose>
</ul>
</div>
