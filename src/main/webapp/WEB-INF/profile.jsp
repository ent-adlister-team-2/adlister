<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile"/>
    </jsp:include>
</head>
<body class="homepage-background">
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container">
    <div class="row">
        <div class="column login-box">
            <h1 class="title">Welcome, ${household.username}!</h1>
            <div class="user-box">
<%--                <h2 class="title">Username: ${household.username}</h2>--%>
                <a href="${pageContext.request.contextPath}/profile/change-username">
                    <button>Change Username</button>
                    <span></span>
                </a>
            </div>
            <div class="user-box">
<%--                <h2 class="title">Email: ${household.email}</h2>--%>
                <a href="${pageContext.request.contextPath}/profile/change-email">
                    <button>Change Email</button>
                    <span></span>
                </a>
            </div>
            <div class="user-box">
<%--                <h2 class="title">Household Name: ${household.name}</h2>--%>
                <a href="${pageContext.request.contextPath}/profile/change-name">
                    <button>Change Name</button>
                    <span></span>
                </a>
            </div>
            <div class="user-box">
<%--                <h2 class="title">Password:</h2>--%>
                <a href="${pageContext.request.contextPath}/profile/change-password">
                    <button>Change Password</button>
                    <span></span>
                </a>
            </div>

            <div class="user-box">
<%--                <h2 class="title">Delete Your Account</h2>--%>
                <a href="${pageContext.request.contextPath}/profile/delete">
                    <button>Delete Your Account</button>
                    <span></span>
                </a>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/partials/footer.jsp"></jsp:include>
</body>
</html>
