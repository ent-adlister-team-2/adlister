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
            System.out.println(taskId);
            Task taskDetails = DaoFactory.getTasksDao().findById(taskId);
            System.out.println(taskDetails.getName());
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

        long taskId = Long.parseLong(request.getParameter("id"));
        try {
            Task task = DaoFactory.getTasksDao().findById(taskId);
            task.setName(name);
            task.setDescription(description);

            DaoFactory.getTasksDao().updateName(task.getId(), task.getName());
            DaoFactory.getTasksDao().updateDescription(task.getId(), task.getDescription());
            response.sendRedirect("/tasks");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
