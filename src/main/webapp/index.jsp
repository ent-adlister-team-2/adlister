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
    <div class="row justify-space-between">
        <div class="column justify-center">
            <div class="row justify-center margin-top-1">
                <img src="images/tasklist-hero2.png" alt="img" class="hero-image">
            </div>
            <div class="row justify-center margin-top-7">
                <img src="images/tasklist-hero1.png" alt="img" class="hero-image">
            </div>
        </div>
        <div class="row justify-center homepage-text">
            <h2>
                <div class="title">
                    <p>
                        Start Simplifying Your Household Chores Today!
                    </p>
                    <p>
                        Welcome to Task Lister - Simplify Your Household Chores!
                    </p>

                    <p>
                        Task Lister is your go-to platform for effortlessly managing household chores. Designed with
                        efficiency
                    </p>
                    <p>
                        in mind, Task Lister empowers you to keep track of your to-do list and conquer your tasks with
                        ease.
                    </p>


                </div>
                <div class="margin-top-7">
                    <h2>
                        Here's what you can do:
                    </h2>
                    <ul>
                        <li>
                            Create and Customize Tasks:
                        </li>
                        <li>
                            Easy Sign-Up Process:
                        </li>
                        <li>
                            Mark Tasks as Repeatable:
                        </li>
                        <li>
                            Organize Tasks by Alphabetical order:
                        </li>
                        <li>
                            User-Friendly Interface:
                        </li>
                    </ul>
                </div>
            </h2>
        </div>
    </div>

    <div class="align-bottom nav-list">
        <h1 class="title user-box">
            <p style="font-size: 2em">
                Creators:
            </p>
            <ul class="title user-box">
                <li class="btn"><a href="https://github.com/TyONeal">Ty Oneal</a></li>
                <li class="btn"><a href="https://github.com/audreytan1127">Audrey Tan</a></li>
                <li class="btn"><a href="https://github.com/Kurt-Suttin">Kurt Suttin</a></li>
            </ul>
        </h1>
    </div>
</main>
<jsp:include page="/WEB-INF/partials/footer.jsp"></jsp:include>
</body>
</html>
