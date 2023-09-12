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

@WebServlet ("/tasks/view/edit")
public class EditTaskServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getSession().getAttribute("household") == null) {
            response.sendRedirect("/login");
            return;
        }
        try {
            long taskId = Long.parseLong(request.getParameter("id"));
            Task taskDetails = DaoFactory.getTasksDao().findById(taskId);
            request.setAttribute("task", taskDetails);
            request.getRequestDispatcher("/WEB-INF/tasks/edit.jsp").forward(request, response);

        } catch(SQLException e) {
            throw new RuntimeException("Error editing your task.", e);
        }

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
//        String category = request.getParameter("category");
//        int status = Integer.parseInt(request.getParameter("repeatable"));
Boolean repeatable = request.getParameter("repeatable") != null;
        long taskId = Long.parseLong(request.getParameter("id"));
        try {
            Task task = DaoFactory.getTasksDao().findById(taskId);
            task.setName(name);
            task.setDescription(description);
            task.setRepeatable(repeatable);
            DaoFactory.getTasksDao().updateName(task.getId(), task.getName());
            DaoFactory.getTasksDao().updateDescription(task.getId(), task.getDescription());
            DaoFactory.getTasksDao().updateRepeatable(task.getId(), task.getRepeatable());
            response.sendRedirect("/tasks");
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}

