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
import java.util.List;

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


        String password = request.getParameter("password");
        String oldEmail = request.getParameter("old-email");
        String newEmail = request.getParameter("new-email");

        Boolean validPassword = BCrypt.checkpw(password, loggedInHousehold.getPassword());
        Boolean validEmail = loggedInHousehold.getEmail().equals(oldEmail);

        List<Household> households = DaoFactory.getHouseholdsDao().all();

        for(Household household : households) {
           if (newEmail.equals(household.getEmail())) {
               request.setAttribute("emailNotAvailable", true);
               request.getRequestDispatcher("/WEB-INF/households/change-email.jsp").forward(request, response);
               return;
            }
        }
        if(!validEmail) {
            request.setAttribute("invalidEmail", true);
            request.getRequestDispatcher("/WEB-INF/households/change-email.jsp").forward(request, response);
        }
        if(!validPassword) {
            request.setAttribute("invalidPassword", true);
            request.getRequestDispatcher("/WEB-INF/households/change-email.jsp").forward(request, response);
        }
        if(validPassword && validEmail) {
            loggedInHousehold.setEmail(newEmail);
            try{
            DaoFactory.getHouseholdsDao().updateEmail(loggedInHousehold.getId(), loggedInHousehold.getEmail());
            response.sendRedirect("/profile");
            } catch (SQLException e) {
                throw new RuntimeException("Unable to update Email.", e);
            }
        } else {
            response.sendRedirect("/profile/change-email");
        }
    }
}
