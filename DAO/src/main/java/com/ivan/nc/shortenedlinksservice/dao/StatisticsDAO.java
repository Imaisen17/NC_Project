package com.ivan.nc.shortenedlinksservice.dao;

import com.ivan.nc.shortenedlinksservice.model.Statistics;

import java.sql.SQLException;
import java.util.List;

public interface StatisticsDAO {
    List<Statistics> getAllStatByAuthorId(int authorId) throws SQLException;

    Statistics getAllStatByRef(String refShortAddress) throws SQLException;

}
