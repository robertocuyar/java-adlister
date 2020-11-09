package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.LoginCheckDao;
import com.codeup.adlister.dao.MySQLUsersDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.codeup.adlister.Config;

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    Config config = new Config();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        LoginCheckDao check = new LoginCheckDao(config);

        boolean validAttempt = check.searchUsernamePassword(username, password);
        if (validAttempt) {
            request.getSession().setAttribute("user", DaoFactory.getUsersDao().findByUsername(username));
            response.sendRedirect("/profile");
        } else {
            response.sendRedirect("/login");
        }
    }
}
