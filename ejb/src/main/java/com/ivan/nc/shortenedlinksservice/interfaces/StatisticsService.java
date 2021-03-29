package com.ivan.nc.shortenedlinksservice.interfaces;

import com.ivan.nc.shortenedlinksservice.entity.Statistics;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface StatisticsService {
    List<Statistics> getAllStatByAuthorId(int authorId) throws SQLException;

   List <Statistics> getAllStatByRef(String shortRef) throws SQLException;

    List<Statistics> getAll() throws SQLException;

    void createStat(int idAuthor, String refShortAdr, int numbOfTrans);



}
