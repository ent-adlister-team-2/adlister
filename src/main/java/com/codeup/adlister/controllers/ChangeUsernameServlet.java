package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Household;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/profile/change-username")
public class ChangeUsernameServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("household") == null) {
            response.sendRedirect("/login");
            return;
        }
        Household household = (Household) request.getSession().getAttribute("household");
        request.setAttribute("household", household);
        request.getRequestDispatcher("/WEB-INF/households/change-username.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Household loggedInHousehold = (Household) request.getSession().getAttribute("household");

        String oldUsername = request.getParameter("old-username");
        String newUsername = request.getParameter("new-username");
        String password = request.getParameter("password");

        Boolean validUsername = loggedInHousehold.getUsername().equals(oldUsername);
        Boolean validPassword = BCrypt.checkpw(password, loggedInHousehold.getPassword());

        if(validUsername && validPassword) {
            loggedInHousehold.setUsername(newUsername);
            try {
                DaoFactory.getHouseholdsDao().updateUsername(loggedInHousehold.getId(), loggedInHousehold.getUsername());
                response.sendRedirect("/profile");
            } catch (SQLException e) {
                throw new RuntimeException("Unable to change Username, please try again.", e);
            }
        } else {
            response.sendRedirect("/profile/change-username");
        }
    }
}
