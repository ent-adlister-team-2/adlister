package com.codeup.adlister.controllers;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.HelloWorldServlet", urlPatterns = "/landing")
public class LandingPageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getRequestDispatcher("/landing.jsp");
    }
}
