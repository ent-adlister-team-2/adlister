package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.MySQLHouseholdsDao;
import com.codeup.adlister.models.Household;
import com.codeup.adlister.util.Password;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet ("/change-password")
public class ChangePasswordServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        Household household = (Household) request.getSession().getAttribute("user");
        request.setAttribute("household", household);
        request.getRequestDispatcher("/WEB-INF/change-password.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Household loggedInHousehold = (Household) request.getSession().getAttribute("user");

        String username = request.getParameter("username");
        String oldPassword = request.getParameter("old-password");
        String newPassword = request.getParameter("new-password");
        String hashedNewPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt());

        Household household = DaoFactory.getUsersDao().findByUsername(username);
        boolean validAttempt = Password.check(oldPassword, household.getPassword());

        if(validAttempt) {
            household.setPassword(hashedNewPassword);
            try {
                DaoFactory.getUsersDao().update(loggedInHousehold.getId(), hashedNewPassword);
            } catch (SQLException e) {
                throw new RuntimeException("Unable to update password", e);
            }
        }
        else response.sendRedirect("/create-password");

    }
}
