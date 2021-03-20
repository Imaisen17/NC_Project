package com.ivan.nc.shortenedlinksservice.servlet;

import com.ivan.nc.shortenedlinksservice.model.Statistics;
import com.ivan.nc.shortenedlinksservice.service.StatisticsService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class StatisticsReference extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String shortAddress = req.getParameter("shortAddress");
        StatisticsService statisticsService = new StatisticsService();
        try {
            List<Statistics> statisticsRefList;
            statisticsRefList = statisticsService.showByRef(shortAddress);
            req.setAttribute("statisticsRefList", statisticsRefList);
            req.getRequestDispatcher("WEB-INF/statisticsRef.jsp").forward(req,resp);
            HttpSession session = req.getSession(); // session scope
            Integer openedCntObj = (Integer)session.getAttribute("openCount");
            int openedCnt = 0;
            if (openedCntObj != null) {
                openedCnt = openedCntObj;
            }
            session.setAttribute("openCount", ++openedCnt);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
