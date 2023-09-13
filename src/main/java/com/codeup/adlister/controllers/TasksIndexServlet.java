package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Household;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.AdsIndexServlet", urlPatterns = "/tasks")
public class TasksIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("household") == null) {
            response.sendRedirect("/login");
            return;
        }
        Household household = (Household) request.getSession().getAttribute("household");
        Long houseId = household.getId();
        String completeTask = request.getParameter("complete");
        String incompleteTask = request.getParameter("incomplete");
        if(completeTask != null){
            request.setAttribute("complete", true);
        }
        if(incompleteTask != null){
            request.setAttribute("incomplete", true);
        }
        request.setAttribute("tasks", DaoFactory.getTasksDao().all(houseId));
        request.getRequestDispatcher("/WEB-INF/tasks/homepage.jsp").forward(request, response);

    }
}
