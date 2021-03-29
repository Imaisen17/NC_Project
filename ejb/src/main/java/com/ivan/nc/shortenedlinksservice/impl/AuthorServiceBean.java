package com.ivan.nc.shortenedlinksservice.impl;

import com.ivan.nc.shortenedlinksservice.entity.Author;
import com.ivan.nc.shortenedlinksservice.entity.AuthorDTO;
import com.ivan.nc.shortenedlinksservice.interfaces.AuthorService;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.SQLException;
import java.util.List;

@Stateless
public class AuthorServiceBean implements AuthorService {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Author> getAll() throws SQLException {
        List<Author> authors = entityManager
                .createQuery("Select a from Author a", Author.class)
                .getResultList();
        return authors;
    }

    @Override
    public List<AuthorDTO> getAllWithRef() throws SQLException {
        return null;
    }

    @Override
    public Author getById(int id) throws SQLException {
        Author author = entityManager.find(Author.class, id);
        return author;
    }

    @Override
    public void create(String name) throws SQLException {
        Author author = new Author();
        author.setName(name);
        entityManager.persist(author);

    }


    @Override
    public void delete(int id) throws SQLException {
        Author author = entityManager.find(Author.class, id);
        entityManager.remove(author);
    }

    /*@EJB
    private  Connection connection;

    public AuthorServiceBean() {
        connection = DbConnection.getConnection();
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
            SQL = "DELETE FROM Statistics WHERE id_author = ?";
            PreparedStatement preparedStatement1 = connection.prepareStatement(SQL);
            statement.setInt(1,id);
            statement.executeUpdate();
            preparedStatement1.close();
            SQL = "DELETE FROM Author where id=?";
            PreparedStatement preparedStatement2 = connection.prepareStatement(SQL);
            preparedStatement2.setInt(1,id);
            preparedStatement2.executeUpdate();
            preparedStatement2.close();
        }
    }*/
}
