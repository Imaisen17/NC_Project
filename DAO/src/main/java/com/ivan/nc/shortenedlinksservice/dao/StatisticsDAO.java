package com.ivan.nc.shortenedlinksservice.dao;

import com.ivan.nc.shortenedlinksservice.model.Statistics;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface StatisticsDAO {
    List<Statistics> getAllStatByAuthorId(int authorId) throws SQLException;

    List<Statistics> getAllStatByRef(String refShortAddress) throws SQLException;

    List<Statistics> getAll() throws SQLException;


}
