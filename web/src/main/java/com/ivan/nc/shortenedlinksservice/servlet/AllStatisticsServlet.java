/*
package com.ivan.nc.shortenedlinksservice.servlet;

import com.ivan.nc.shortenedlinksservice.entity.Statistics;
import com.ivan.nc.shortenedlinksservice.impl.StatisticsService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AllStatisticsServlet extends HttpServlet {
    @EJB
    StatisticsService statisticsService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Statistics> statisticsList;
        {
            try {
                statisticsList = statisticsService.showAllStat();
                req.setAttribute("statisticsList", statisticsList);
                String adr = req.getRemoteAddr();
                String usr = req.getHeader("User-Agent");
                req.setAttribute("adr", adr);
                req.setAttribute("usr", usr);

                req.getRequestDispatcher("WEB-INF/allStat.jsp").forward(req,resp);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
*/
