package com.ivan.nc.shortenedlinksservice.dao;

import com.ivan.nc.shortenedlinksservice.model.Statistics;
import com.ivan.nc.shortenedlinksservice.util.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StatisticsDAOImpl extends DbConnection implements StatisticsDAO {
    Date date = new Date(System.currentTimeMillis());
    private Connection connection;

    public StatisticsDAOImpl() {
        this.connection = getConnection();;
    }

    @Override
    public List<Statistics> getAllStatByAuthorId(int authorId) throws SQLException {
        List<Statistics> list = new ArrayList<>();
        String SQL = "SELECT * FROM Statistics where id_author = ?";
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
    public List<Statistics> getAllStatByRef(String refShortAddress) throws SQLException {
        List<Statistics> statisticsList = new ArrayList<>();
        String SQL = "SELECT * FROM Statistics where ref_short_adr = ?";
        try (PreparedStatement statement = connection.prepareStatement(SQL)
        ) {
            statement.setString(1, refShortAddress);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Statistics statistics = new Statistics();
                statistics.setIdAuthor(resultSet.getInt("id_author"));
                statistics.setRefShortAdr(resultSet.getString("ref_short_adr"));
                statistics.setNumbOfTrans(resultSet.getInt("numb_of_trans"));
                statistics.setLastTrans(date);
                statisticsList.add(statistics);

            }
        }
        return statisticsList;
    }

    @Override
    public List<Statistics> getAll() throws SQLException {
        List<Statistics> statisticsList = new ArrayList<>();
        String SQL = "SELECT * FROM Statistics";
        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Statistics statistics = new Statistics();
                statistics.setIdAuthor(resultSet.getInt("id_author"));
                statistics.setRefShortAdr(resultSet.getString("ref_short_adr"));
                statistics.setNumbOfTrans(resultSet.getInt("numb_of_trans"));
                statistics.setLastTrans(date);
                statisticsList.add(statistics);
            }
        }
        return statisticsList;
    }
}
