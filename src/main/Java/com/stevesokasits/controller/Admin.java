package com.stevesokasits.controller;

import com.stevesokasits.persistence.UserDao;

import javax.servlet.http.HttpServlet;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet(
        name = "adminUserServlet",
        urlPatterns = {"/adminUser"}
)

public class Admin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        System.out.println("here!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        UserDao userDao = new UserDao();

        if (req.getParameter("submit").equals("Display All Resources")) {
            req.setAttribute("users", userDao.getAllUsers());
        }
        System.out.println("now +++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/content/admin/displayAllResources.jsp");
        dispatcher.forward(req, resp);
    }
}


