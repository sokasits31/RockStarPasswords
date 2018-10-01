package com.stevesokasits.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import edu.matc.persistence.UserDao;
import edu.matc.persistence.UserData;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * A simple servlet to welcome the user.
 * @author pwaite
 */

@WebServlet(
        urlPatterns = {"/searchUser"}
)

public class Admin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //UserDao userDao = new UserDao();

        if (req.getParameter("submit").equals("addResource")) {

        } else {
            if (req.getParameter("submit").equals("updateResource")) {

            } else {
                if (req.getParameter("submit").equals("deleteResource")) {

                }
            } else {

            }
        }

        if (req.getParameter("submit").equals("Select All")) {
            req.setAttribute("users", userDao.getAllUsers());
        } else {
            req.setAttribute("users", userDao.getAllUsers(req.getParameter("searchTerm"), req.getParameter("searchType")));
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }
}


