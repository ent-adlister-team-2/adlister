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

@WebServlet ("profile/delete")
public class DeleteHouseholdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getSession().getAttribute("household") == null) {
            response.sendRedirect("/login");
            return;
        }
        Household household = (Household) request.getSession().getAttribute("household");
        request.setAttribute("household", household);
        request.getRequestDispatcher("/WEB-INF/households/delete-household.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        Household loggedInHousehold = (Household) request.getSession().getAttribute("household");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm-password");

        Boolean validUsername = loggedInHousehold.getUsername().equals(username);
        Boolean validPassword = BCrypt.checkpw(loggedInHousehold.getPassword(), password);
        Boolean validConfirm = BCrypt.checkpw(loggedInHousehold.getPassword(), confirmPassword);

        if (validUsername && validPassword && validConfirm) {
            try {
                DaoFactory.getHouseholdsDao().deleteHousehold(loggedInHousehold.getId());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
