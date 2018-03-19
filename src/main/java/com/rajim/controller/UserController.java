package com.rajim.controller;

import com.rajim.dao.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserController extends HttpServlet {

    private static String INSERT_OR_EDIT = "/user.jsp";

    private static String LIST_USER = "/userList.jsp";

    private UserDao userDao;

    public UserController() {
        super();
        userDao = new UserDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("test");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String forward = "";
        String action = request.getParameter("action");
        if(action.equalsIgnoreCase("userList")) {
            forward = LIST_USER;
            request.setAttribute("users", userDao.getAllUsers());
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
        dispatcher.forward(request, response);
    }
}
