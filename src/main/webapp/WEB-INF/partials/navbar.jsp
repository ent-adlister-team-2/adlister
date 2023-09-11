<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="navbar navbar-back-ground padding-5">
    <a class="navbar nav-title margin-left-1" href="/tasks">Tasklister</a>
    <ul class="navbar ul">
        <c:choose>
            <c:when test="${sessionScope.household == null}">
                <ul class="navbar ul-left">
                    <li class="navbar li"><a href="/profile">Profile</a></li>
<%--                    <li class="navbar li"><a href="/tasks">Home/Tasks</a></li>--%>
                </ul>
                <ul class="navbar ul">
                    <li class="navbar li"><a href="/login">Login</a></li>
                    <li class="navbar li"><a href="/register">Sign Up</a></li>
                </ul>

            </c:when>
            <c:otherwise>
                <li class="navbar li"><a href="/logout">Logout</a></li>
                <li class="navbar li"><a href="/profile">Profile</a></li>
            </c:otherwise>
        </c:choose>
    </ul>
</div>
