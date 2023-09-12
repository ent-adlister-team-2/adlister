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

@WebServlet ("/profile/delete")
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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Household loggedInHousehold = (Household) request.getSession().getAttribute("household");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm-password");
        String confirmUsername = request.getParameter("user-confirm");

        Boolean validUsername = loggedInHousehold.getUsername().equals(username);
        Boolean validPassword = BCrypt.checkpw(password, loggedInHousehold.getPassword());
        Boolean validPasswordConfirm = BCrypt.checkpw(confirmPassword, loggedInHousehold.getPassword());
        Boolean validUserConfirm = loggedInHousehold.getUsername().equals(confirmUsername);

        if (validUsername && validPassword && validPasswordConfirm && validUserConfirm) {
            try {
                request.getSession().invalidate();
                DaoFactory.getHouseholdsDao().deleteHousehold(loggedInHousehold.getId());
                response.sendRedirect("/login");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            response.sendRedirect("/profile/delete");
        }
    }
}
