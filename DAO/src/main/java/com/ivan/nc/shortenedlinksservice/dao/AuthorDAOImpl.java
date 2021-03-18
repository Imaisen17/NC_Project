package com.ivan.nc.shortenedlinksservice.dao;

import com.ivan.nc.shortenedlinksservice.DTO.AuthorDTO;
import com.ivan.nc.shortenedlinksservice.model.Author;
import com.ivan.nc.shortenedlinksservice.util.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAOImpl extends DbConnection implements AuthorDAO {

    private Connection connection;

    public AuthorDAOImpl() {
        connection = getConnection();
    }

    public List<Author> getAll() throws SQLException {
        List<Author> list = new ArrayList<Author>();
        String SQL = "SELECT * FROM Author";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL)) {
            while (resultSet.next()) {
                Author author = new Author();
                author.setId(resultSet.getInt("id"));
                author.setName(resultSet.getString("name"));
                list.add(author);
            }
        }
        return list;
    }

    @Override
    public List<AuthorDTO> getAllWithRef() throws SQLException {
        List<AuthorDTO> list = new ArrayList<>();
        String SQL = "select author.id, author.name, " +
                "count(reference.author_id) countReferences from author left join reference " +
                "on author.id=reference.author_id " +
                "group by author.id, author.name " +
                "order by author.id";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL)) {
            while (resultSet.next()) {
                AuthorDTO author = new AuthorDTO();
                author.setId(resultSet.getInt("id"));
                author.setName(resultSet.getString("name"));
                author.setRefCount(resultSet.getInt("countReferences"));
                list.add(author);
            }
        }
        return list;
    }


    @Override
    public Author getById(int id) throws SQLException {
        Author author = null;
        String SQL = "SELECT name, id FROM Author where id =" + id;
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL)) {
            resultSet.next();
            int author_id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            author = new Author(author_id, name);

        }
        return author;
    }

    @Override
    public void create(String name) throws SQLException {
        String SQL = "INSERT INTO Author(name) VALUES(?)";
        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setString(1, name);
            statement.executeUpdate();
        }

    }

    @Override
    public Author update(int id, String name) throws SQLException {
        Author author = new Author();
        String SQL = "UPDATE Author SET name = ? where id = ?";
        try(PreparedStatement statement = connection.prepareStatement(SQL)){
            statement.setString(1, name);
            statement.setInt(2, id);
            statement.executeUpdate();
        }
        return author;
    }

    @Override
    public void delete(int id) throws SQLException {
        String SQL = "DELETE FROM Reference where author_id=?";
        try(PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setInt(1, id);
            statement.executeUpdate();
            SQL = "DELETE FROM Author where id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
    }
}
