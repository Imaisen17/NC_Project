package com.ivan.nc.shortenedlinksservice.servlet;

import com.ivan.nc.shortenedlinksservice.entity.Statistics;
import com.ivan.nc.shortenedlinksservice.interfaces.StatisticsService;


import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class StatisticsReference extends HttpServlet {
    @EJB
    StatisticsService statisticsService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String shortAddress = req.getParameter("refShortAdr");
        System.out.println(shortAddress);
        try {
            List<Statistics> statistics;
            statistics = statisticsService.getAllStatByRef(shortAddress);
            req.setAttribute("statistics", statistics);
            req.getRequestDispatcher("WEB-INF/statisticsRef.jsp").forward(req,resp);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
