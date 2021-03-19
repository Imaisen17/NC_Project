package com.ivan.nc.shortenedlinksservice.dao;

import com.ivan.nc.shortenedlinksservice.model.Statistics;
import com.ivan.nc.shortenedlinksservice.util.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StatisticsDAOImpl extends DbConnection implements StatisticsDAO {
    private Connection connection;

    public StatisticsDAOImpl() {
        this.connection = getConnection();;
    }

    @Override
    public List<Statistics> getAllStatByAuthorId(int authorId) throws SQLException {
        List<Statistics> list = new ArrayList<>();
        String SQL = "SELECT * FROM Statistics where id_author = ?";
        Date date = new Date(System.currentTimeMillis());
        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setInt(1, authorId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Statistics statistics = new Statistics();
                statistics.setIdAuthor(resultSet.getInt("id_author"));
                statistics.setRefShortAdr(resultSet.getString("ref_short_adr"));
                statistics.setNumbOfTrans(resultSet.getInt("numb_of_trans"));
                statistics.setLastTrans(date);
                list.add(statistics);
            }
        }
        return list;
    }

    @Override
    public Statistics getAllStatByRef(String refShortAddress) throws SQLException {
        Statistics statistics = null;
        String SQL = "SELECT id_author, ref_short_adr, numb_of_trans, last_trans where ref_short_adr = ?";
        try (PreparedStatement statement = connection.prepareStatement(SQL)
        ) {
            statement.setString(1, refShortAddress);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int authorId = resultSet.getInt("id_author");
                String shortAdr = resultSet.getString("ref_short_adr");
                Date lastTrans = resultSet.getDate("last_trans");
                int numbOfTrans = resultSet.getInt("numb_of_trans");
                statistics = new Statistics(authorId, shortAdr, numbOfTrans, lastTrans);
                resultSet.close();
            }
        }
        return statistics;
    }
}
