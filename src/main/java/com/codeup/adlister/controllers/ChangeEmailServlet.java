package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Household;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet ("/profile/change-email")
public class ChangeEmailServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getSession().getAttribute("household") == null) {
            response.sendRedirect("/login");
            return;
        }

        request.getParameter("emailNotAvailable");
        Household household = (Household) request.getSession().getAttribute("household");
        request.setAttribute("household", household);
        request.getRequestDispatcher("/WEB-INF/households/change-email.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Household loggedInHousehold = (Household) request.getSession().getAttribute("household");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm-password");
        String oldEmail = request.getParameter("old-email");
        String newEmail = request.getParameter("new-email");

        Boolean validUsername = loggedInHousehold.getUsername().equals(username);
        Boolean validPassword = BCrypt.checkpw(password, loggedInHousehold.getPassword());
        Boolean validConfirm = BCrypt.checkpw(confirmPassword, loggedInHousehold.getPassword());
        Boolean validEmail = loggedInHousehold.getEmail().equals(oldEmail);

        Boolean emailNotAvailable = DaoFactory.getHouseholdsDao().findByEmail(newEmail).getEmail().equals(newEmail);

        if(validUsername && validPassword && validConfirm && validEmail && !emailNotAvailable) {
            loggedInHousehold.setEmail(newEmail);
            try{
            DaoFactory.getHouseholdsDao().updateEmail(loggedInHousehold.getId(), loggedInHousehold.getEmail());
            response.sendRedirect("/profile");
            } catch (SQLException e) {
                throw new RuntimeException("Unable to update Email.", e);
            }
        } else if (validUsername && validPassword && validConfirm && emailNotAvailable) {
            request.setAttribute("emailNotAvailable", true);
            request.getRequestDispatcher("/WEB-INF/households/change-email.jsp").forward(request, response);
        }
        else {
            response.sendRedirect("/profile/change-email");
        }
    }
}
