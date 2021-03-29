package com.ivan.nc.shortenedlinksservice.servlet;


import com.ivan.nc.shortenedlinksservice.entity.Reference;
import com.ivan.nc.shortenedlinksservice.interfaces.ReferenceService;
import com.ivan.nc.shortenedlinksservice.interfaces.StatisticsService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ReferenceAdd extends HttpServlet {
    @EJB
    ReferenceService referenceService;

    @EJB
    StatisticsService statisticsService;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/newReference.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String fullAddress = req.getParameter("fullAddress");
        String shortAddress = req.getParameter("shortAddress");
        System.out.println("here shortaddress"+req.getParameter("shortAddress"));
        int authorId = Integer.parseInt(req.getParameter("authorId"));
        System.out.println(authorId);
        try {
            referenceService.create(fullAddress, authorId);
            System.out.println(shortAddress);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        resp.sendRedirect("author");
    }
}
