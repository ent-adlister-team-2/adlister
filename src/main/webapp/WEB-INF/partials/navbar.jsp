<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="navbar navbar-back-ground padding-5 navbar-placement">

    <div class="row">
        <div class="mr-1">
            <img class="task-list-image" src="/images/task-list-image.jpeg" alt="image">
        </div>
        <div class="navbar-task-lister">
            <a class="column navbar nav-title " href="/tasks"> Manage Tasklister</a>
        </div>
    </div>

    <div class="column">


        <ul class="navbar ul">
            <c:choose>
                <c:when test="${sessionScope.household == null}">
                    <div class="row ">
                        <div class="column">
                            <ul class="navbar ul">
                                <li class="navbar li nav-title"><a href="/profile">Profile</a></li>
                            </ul>
                        </div>
                        <div class="column">
                            <ul class="navbar ul">
                                <li class="navbar li nav-title"><a href="/login">Login</a></li>
                            </ul>
                        </div>
                        <div class="column">
                            <ul class="navbar ul ">
                                <li class="navbar li nav-title"><a href="/register">Register</a></li>
                            </ul>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <li class="navbar li nav-title logout-notify"><a href="/logout">Logout</a></li>
                    <li class="navbar li nav-title"><a href="/profile">Profile</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</div>
<jsp:include page="/WEB-INF/partials/footer.jsp"></jsp:include>
