<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body class="background">
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>Welcome, ${household.username}!</h1>
        <div>
            <h2>Username: ${household.username}</h2>
            <a href="${pageContext.request.contextPath}/profile/change-username">
                <button>Change Username</button>
            </a>
        </div>
        <div>
            <h2>Email: ${household.email}</h2>
            <a href="${pageContext.request.contextPath}/profile/change-email">
                <button>Change Email</button>
            </a>
        </div>
        <div>
            <h2>Household Name: ${household.name}</h2>
            <a href="${pageContext.request.contextPath}/profile/change-name">
                <button>Change Name</button>
            </a>
        </div>
        <div>
            <h2>Password:</h2>
            <a href="${pageContext.request.contextPath}/profile/change-password">
                <button>Change Password</button>
            </a>
        </div>

        <div>
            <h2>Delete Your Account</h2>
            <a href="${pageContext.request.contextPath}/profile/delete">
                <button>Delete</button>
            </a>
        </div>
    </div>


</body>
</html>
