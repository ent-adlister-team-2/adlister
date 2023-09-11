//package com.codeup.adlister.controllers;
//
//import com.codeup.adlister.dao.DaoFactory;
//import com.codeup.adlister.models.Household;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.sql.SQLException;
//
//@WebServlet ("/view-task/edit")
//public class EditTaskServlet extends HttpServlet {
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        if (request.getSession().getAttribute("household") == null) {
//            response.sendRedirect("/login");
//            return;
//        }
//        Household household = (Household) request.getSession().getAttribute("household");
//        request.setAttribute("household", household);
//        request.getRequestDispatcher("/WEB-INF/tasks/edit.jsp").forward(request, response);
//
//    }
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
//        String name = request.getParameter("name");
//        String description = request.getParameter("description");
//        String category = request.getParameter("category");
//        Boolean complete = Boolean.parseBoolean(request.getParameter("completion-status"));
//        Boolean repeatable = Boolean.parseBoolean(request.getParameter("repeatable"));
//        request.getParameter("task");
//        try {
//            DaoFactory.getTasksDao().updateName(name);
//
//        } catch(SQLException e) {
//            throw new RuntimeException("Error editing your task.", e);
//        }
//
//    }
//}
