package com.ivan.nc.shortenedlinksservice.dao;

import com.ivan.nc.shortenedlinksservice.model.Reference;
import com.ivan.nc.shortenedlinksservice.util.DbConnection;
import me.nimavat.shortid.ShortId;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReferenceDAOImpl extends DbConnection implements ReferenceDAO {




    private Connection connection;

    public ReferenceDAOImpl() {
        this.connection = getConnection();
    }

    @Override
    public List<Reference> getAll() {
        List<Reference> list = new ArrayList<Reference>();
        String SQL = "SELECT * FROM REFERENCE";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL)) {
            while (resultSet.next()) {
                Reference reference = new Reference();
                reference.setFullAddress(resultSet.getString("full_address"));
                reference.setShortAddress(resultSet.getString("short_address"));
                reference.setDateCreate(resultSet.getDate("date_create"));
                reference.setAuthorId(resultSet.getInt("author_id"));
                list.add(reference);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public Reference getByShortAddress(String short_address) {
        Reference reference = null;
        String SQL = "SELECT short_address, full_address, date_create, author_id FROM REFERENCE where short_address =?" ;
        try (PreparedStatement statement = connection.prepareStatement(SQL)
             ) {
            statement.setString(1, short_address);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
            String short_address_link = resultSet.getString("short_address");
            String full_address = resultSet.getString("full_address");
            Date date_create = resultSet.getDate("date_create");
            int author_id = resultSet.getInt("author_id");
            reference = new Reference(short_address_link, full_address, date_create, author_id);
            resultSet.close();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return reference;
    }

    @Override
    public void create(String fullAddress, int authorId) throws SQLException {
        String SQL = "INSERT INTO Reference values(?,?,?,?)";
        Date date = new Date(System.currentTimeMillis());
        date.toString();

        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setString(1, fullAddress);
            statement.setString(2, ShortId.generate());
            statement.setDate(3,  date);
            statement.setInt(4,authorId);
            statement.executeUpdate();

        }
    }

    @Override
    public Reference update(String shortAddress, String fullAddress, int authorId) throws SQLException{
        Reference reference = null;
        String SQL = "UPDATE Reference SET short_address=?,full_address= ?, author_id=? where short_address = ?";
        try(PreparedStatement statement = connection.prepareStatement(SQL)){
            statement.setString(1, shortAddress);
            statement.setString(2, fullAddress);
            statement.setInt(3,authorId);
            statement.setString(4, shortAddress);
            statement.executeUpdate();
            reference = getByShortAddress(shortAddress);
        }
        return reference;
    }

    @Override
    public void delete(String shortAddress) throws SQLException {
        String SQL = "DELETE FROM Reference where short_address =?";
        try(PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setString(1, shortAddress);
            statement.executeUpdate();
        }
    }
}
