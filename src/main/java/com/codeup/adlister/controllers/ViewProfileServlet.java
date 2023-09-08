package com.codeup.adlister.controllers;

import com.codeup.adlister.models.Household;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("household") == null) {
            response.sendRedirect("/login");
            return;
        }
        Household household = (Household) request.getSession().getAttribute("household");
        request.setAttribute("household", household);
        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }
}
