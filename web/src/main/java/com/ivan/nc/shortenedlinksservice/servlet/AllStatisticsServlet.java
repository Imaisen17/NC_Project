package com.ivan.nc.shortenedlinksservice.servlet;

import com.ivan.nc.shortenedlinksservice.DTO.AuthorDTO;
import com.ivan.nc.shortenedlinksservice.model.Statistics;
import com.ivan.nc.shortenedlinksservice.service.AuthorService;
import com.ivan.nc.shortenedlinksservice.service.StatisticsService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AllStatisticsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StatisticsService statisticsService = new StatisticsService();
        List<Statistics> statisticsList;
        {
            try {
                statisticsList = statisticsService.showAllStat();
                req.setAttribute("statisticsList", statisticsList);
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
