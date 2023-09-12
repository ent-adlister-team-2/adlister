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
            <div class="row justify-center">
                <img src="images/tasklist-hero2.png" alt="img" class="hero-image">
            </div>
            <div class="row justify-center margin-top-5">
                <img src="images/tasklist-hero1.png" alt="img" class="hero-image">
            </div>
        </div>
        <div class="column justify-center homepage-text">
            <p>
                Welcome to Task Lister - Simplify Your Household Chores!

                Task Lister is your go-to platform for effortlessly managing household chores. Designed with efficiency
                in mind, Task Lister empowers you to keep track of your to-do list and conquer your tasks with ease.
                Here's what you can do:

            <ol>
                <li>
                    Create and Customize Tasks:
                    <ul>
                        <li>Add tasks specific to your household chores, from cleaning and organizing to grocery
                            shopping and more.
                        </li>
                        <li>Customize task names, descriptions, and whether a task is repeatable or not</li>
                    </ul>
                </li>
                <li>
                    Easy Sign-Up Process:
                    <ul>
                        <li>Join our community with a quick and free sign-up process.</li>
                        <li>Create your personal account and start listing tasks right away.</li>
                    </ul>
                </li>
                <li>
                    Mark Tasks as Repeatable:
                    <ul>
                        <li>Stay motivated by ticking off completed tasks as you go.</li>
                        <li>Watch your progress unfold in real-time, giving you a sense of accomplishment.</li>
                    </ul>
                </li>
                <li>
                    Organize Tasks by Alphabetical order:
                    <ul>
                        <li>Alphabetical order is essential for quick lookup and cross-referencing.</li>
                        <li>For individuals with cognitive or visual impairments, alphabetical order can be an important
                            accessibility feature, as it provides a clear and predictable organization method.
                        </li>
                    </ul>
                </li>
                <li>
                    Archive and Review Completed Tasks:
                    <ul>
                        <li>Keep a record of your achievements and completed tasks for future reference.</li>
                        <li>Gain insights into your productivity and celebrate your accomplishments.</li>
                    </ul>
                </li>
                <li>
                    User-Friendly Interface:
                    <ul>
                        <li>Enjoy a clean and intuitive interface that makes managing tasks a breeze.</li>
                        <li>Access your task list anytime, anywhere, from any device.</li>
                    </ul>
                </li>
            </ol>

            Start Simplifying Your Household Chores Today!

            Sign up for Task Lister now and experience the convenience of managing your household tasks like never
            before. Say goodbye to forgotten chores and hello to a well-organized, efficient home life!
            </p>
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
