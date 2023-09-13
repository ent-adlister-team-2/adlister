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

@WebServlet ("/profile/change-password")
public class ChangePasswordServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getSession().getAttribute("household") == null) {
            response.sendRedirect("/login");
            return;
        }
        Household household = (Household) request.getSession().getAttribute("household");
        request.setAttribute("household", household);
        request.getRequestDispatcher("/WEB-INF/households/change-password.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Household loggedInHousehold = (Household) request.getSession().getAttribute("household");

        String oldPassword = request.getParameter("old-password");
        String newPassword = request.getParameter("new-password");
        String hashedNewPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt());

        boolean validPassword = BCrypt.checkpw(oldPassword, loggedInHousehold.getPassword());
        if(!validPassword) {
            request.setAttribute("invalidPassword", true);
            request.getRequestDispatcher("/WEB-INF/households/change-password.jsp").forward(request, response);
        }
        if(validPassword) {
            loggedInHousehold.setPassword(hashedNewPassword);
            try {
                DaoFactory.getHouseholdsDao().updatePassword(loggedInHousehold.getId(), loggedInHousehold.getPassword());
                response.sendRedirect("/profile");
            } catch (SQLException e) {
                throw new RuntimeException("Unable to update password", e);
            }
        }
        else response.sendRedirect("/profile/change-password");
    }
}
