package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Household;
import com.codeup.adlister.models.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.*;

@WebServlet ("/tasks/sort")
public class SortTasksIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Household household = (Household) request.getSession().getAttribute("household");
        Long houseId = household.getId();
        request.setAttribute("tasks", DaoFactory.getTasksDao().sortAllByName(houseId));
        request.getRequestDispatcher("/WEB-INF/tasks/homepage.jsp").forward(request, response);
    }
}
