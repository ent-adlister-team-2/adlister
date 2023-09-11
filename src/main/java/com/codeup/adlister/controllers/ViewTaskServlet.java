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

@WebServlet(urlPatterns = "/tasks/view")
public class ViewTaskServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("household") == null) {
            resp.sendRedirect("/login");
            return;
        }


        try {
        long taskId = Long.parseLong(req.getParameter("id"));
            System.out.println(taskId);
          Task taskDetails = DaoFactory.getTasksDao().findById(taskId);
            System.out.println(taskDetails);
        req.setAttribute("task", taskDetails);
            req.getRequestDispatcher("/WEB-INF/tasks/view-task.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
