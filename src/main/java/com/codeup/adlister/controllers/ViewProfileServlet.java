package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
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
        Household sessionHousehold = (Household) request.getSession().getAttribute("household");
        Household loggedInHousehold = DaoFactory.getHouseholdsDao().findByUsername(sessionHousehold.getUsername());
        request.setAttribute("household", loggedInHousehold);
        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }
}
