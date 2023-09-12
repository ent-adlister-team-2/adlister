package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/tasks/view/delete")
public class DeleteTaskServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("household") == null) {
            resp.sendRedirect("/login");
            return;
        }
        try {
            long taskId = Long.parseLong(req.getParameter("id"));
            Task taskDetails = DaoFactory.getTasksDao().findById(taskId);
            req.setAttribute("task", taskDetails);
            req.getRequestDispatcher("/WEB-INF/tasks/delete.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long taskId = Long.parseLong(req.getParameter("id"));
        DaoFactory.getTasksDao().deleteTask(taskId);
        resp.sendRedirect("/tasks");
    }


}
