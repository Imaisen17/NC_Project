/*
package com.ivan.nc.shortenedlinksservice.servlet;


import com.ivan.nc.shortenedlinksservice.interfaces.Calculator;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CalcServlet extends HttpServlet {
    @EJB
    private Calculator calculator;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int a = Integer.valueOf(req.getParameter("a"));
        int b = Integer.valueOf(req.getParameter("b"));

        int sum = calculator.sum(a, b);
        req.setAttribute("calcResult", sum);

        req.getRequestDispatcher("WEB-INF/calc.jsp").forward(req, resp);
    }
}
*/
