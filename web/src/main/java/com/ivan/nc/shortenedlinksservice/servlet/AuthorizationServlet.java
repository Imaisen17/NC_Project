package com.ivan.nc.shortenedlinksservice.servlet;

import com.ivan.nc.shortenedlinksservice.entity.UserLogin;
import com.ivan.nc.shortenedlinksservice.interfaces.UserLoginService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthorizationServlet extends HttpServlet {
    @EJB
    UserLoginService userLoginService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/loginPage.jsp").forward(req,resp);
        System.out.println(req.getSession());
        HttpSession session = req.getSession(false);
        System.out.println("Servlet auth");
        if (session ==null || session.getAttribute("loggedInUser") == null){
            System.out.println("if auth");
            req.getRequestDispatcher("WEB-INF/loginPage.jsp").forward(req,resp);
        }else{
            System.out.println("else auth");
            resp.sendRedirect("author");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        UserLogin userLogin = new UserLogin();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        userLogin.setLogin(login);
        userLogin.setPassword(password);
        userLoginService.createUser(userLogin);
        session.setAttribute("loggedInUser", userLogin);
        resp.sendRedirect("author");

    }
}
