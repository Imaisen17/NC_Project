package com.ivan.nc.shortenedlinksservice.service;

import com.ivan.nc.shortenedlinksservice.dao.StatisticsDAO;
import com.ivan.nc.shortenedlinksservice.dao.StatisticsDAOImpl;
import com.ivan.nc.shortenedlinksservice.model.Statistics;

import java.sql.SQLException;
import java.util.List;

public class StatisticsService {
    private StatisticsDAO statisticsDAO;

    public StatisticsService(StatisticsDAO statisticsDAO) {
        this.statisticsDAO = new StatisticsDAOImpl();
    }
    public List<Statistics> showByAuthorId(int id) throws SQLException {
        List<Statistics> statisticsList = statisticsDAO.getAllStatByAuthorId(id);
        return statisticsList;
    }

    public Statistics showByRef(String ref) throws SQLException {
        Statistics statistics = statisticsDAO.getAllStatByRef(ref);
        return statistics;
    }
}
