package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Household;
import com.codeup.adlister.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");

        // validate input
        boolean inputHasErrors = username.isEmpty()
            || email.isEmpty()
            || password.isEmpty()
            || (! password.equals(passwordConfirmation));

        if (inputHasErrors) {
            response.sendRedirect("/register");
            return;
        }

        // create and save a new user
        Household household = new Household(username, email, password);

        // hash the password

        String hash = Password.hash(household.getPassword());

        household.setPassword(hash);

        List<Household> households = DaoFactory.getHouseholdsDao().all();

        for(Household householdList : households) {
            if (username.equals(householdList.getUsername())) {
                request.setAttribute("usernameNotAvailable", true);
                request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                return;
            }
            if (email.equals(householdList.getEmail())) {
                request.setAttribute("emailNotAvailable", true);
                request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                return;
            }
        }
        DaoFactory.getHouseholdsDao().insert(household);
        response.sendRedirect("/login");
    }
}
