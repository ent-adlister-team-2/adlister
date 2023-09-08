package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/view_task")
public class ViewTaskServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        if(req.getSession().getAttribute("user") == null) {
//            resp.sendRedirect("/login");
//            // add a return statement to exit out of the entire method.
//            return;
//        }
//
//        req.getRequestDispatcher("/WEB-INF/view-task.jsp").forward(req, resp);
//        req.setAttribute("task", DaoFactory.getTasksDao().viewTask());
//    }

}
