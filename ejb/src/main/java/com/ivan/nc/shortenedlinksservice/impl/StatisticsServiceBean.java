package com.ivan.nc.shortenedlinksservice.impl;


import com.ivan.nc.shortenedlinksservice.entity.Statistics;
import com.ivan.nc.shortenedlinksservice.interfaces.StatisticsService;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Stateless
public class StatisticsServiceBean implements StatisticsService {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Statistics> getAllStatByAuthorId(int authorId) throws SQLException {
        return null;
    }

    @Override
    public List<Statistics> getAllStatByRef(String shortRef) throws SQLException {
       List<Statistics> statistics =
               entityManager.createNativeQuery("Select * From Statistics where refshortadr = "+"'"+shortRef+"'", Statistics.class).getResultList();
        return statistics;
    }

    @Override
    public List<Statistics> getAll() throws SQLException {
        List<Statistics> statisticsList = entityManager.createQuery("select s From Statistics s", Statistics.class).getResultList();
        return statisticsList;
    }

    public void createStat(int idAuthor, String refShortAdr, int numbOfTrans) {
        Statistics statistics = new Statistics();
        statistics.setAuthorId(idAuthor);
        statistics.setRefShortAdr(refShortAdr);
        statistics.setLastTrans(new Date(System.currentTimeMillis()));
        statistics.setNumbOfTrans(numbOfTrans);
        entityManager.persist(statistics);
    }

    /*
@EJB
    private Connection connection;

    Date date = new Date(System.currentTimeMillis());

    public StatisticsServiceBean() {
        this.connection = DbConnection.getConnection();;
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
    }*/

}
