package com.codeup.adlister.controllers;


import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Household;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.AdsIndexServlet", urlPatterns = "/tasks/completed")
public class CompletedTasksServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Household household = (Household) request.getSession().getAttribute("household");
        Long houseId = household.getId();
        request.setAttribute("tasks", DaoFactory.getTasksDao().allCompleted(houseId));
        request.getRequestDispatcher("/WEB-INF/tasks/completed-tasks.jsp").forward(request, response);
    }
}
