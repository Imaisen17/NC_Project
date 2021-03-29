package com.ivan.nc.shortenedlinksservice.impl;

import com.ivan.nc.shortenedlinksservice.entity.Reference;
import com.ivan.nc.shortenedlinksservice.interfaces.ReferenceService;
import me.nimavat.shortid.ShortId;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

@Stateless
public class ReferenceServiceBean implements ReferenceService {
    @PersistenceContext
    EntityManager entityManager;



    @Override
    public List<Reference> getAll() {
        return null;
    }

    @Override
    public List<Reference> getAllById(int id) {
        List<Reference> referenceList = entityManager.createQuery("From Reference where authorId=" + id).getResultList();
        return referenceList;
    }

    @Override
    public Reference getByShortAddress(String short_address) {
        Reference reference = entityManager.find(Reference.class, short_address);
        return reference;
    }

    @Override
    public Reference getByFullAddress(String full_address) {
        Reference reference = (Reference) entityManager.createQuery("From Reference where fullAddress="+full_address,Reference.class);
        return reference;
    }

    @Override
    public void create(String fullAddress, int authorId) throws SQLException {
        Reference reference = new Reference();
        reference.setAuthorId(authorId);
        reference.setFullAddress(fullAddress);
        reference.setShortAddress(ShortId.generate());
        reference.setDateCreate(new Date(System.currentTimeMillis()));
        entityManager.persist(reference);
    }

    @Override
    public Reference update(String shortAddress, String fullAddress, int authorId) throws SQLException {
        Reference reference = new Reference();
        reference.setShortAddress(shortAddress);
        reference.setFullAddress(fullAddress);
        reference.setAuthorId(authorId);
        reference.setDateCreate(new Date(System.currentTimeMillis()));
        entityManager.merge(reference);
        return reference;
    }

    @Override
    public void delete(String shortAddress) throws SQLException {
        Reference reference = entityManager.find(Reference.class, shortAddress);
        entityManager.remove(reference);
    }
    /*@EJB
    private Connection connection;

    public ReferenceServiceBean() {
        this.connection = DbConnection.getConnection();
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
    public List<Reference> getAllById(int id) {
        List<Reference> list = new ArrayList<Reference>();
        String SQL = "SELECT * FROM REFERENCE where author_id =?";
        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
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
        String SQL = "SELECT short_address, full_address, date_create, author_id FROM REFERENCE where short_address =?";
        try (PreparedStatement statement = connection.prepareStatement(SQL)
        ) {
            statement.setString(1, short_address);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
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
    public Reference getByFullAddress(String full_address) {
        Reference reference = null;
        String SQL = "SELECT short_address, full_address, date_create, author_id FROM REFERENCE where full_address =?";
        try (PreparedStatement statement = connection.prepareStatement(SQL)
        ) {
            statement.setString(1, full_address);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String short_address_link = resultSet.getString("short_address");
                String full_addressTemp = resultSet.getString("full_address");
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
            statement.setDate(3, date);
            statement.setInt(4, authorId);
            statement.executeUpdate();

        }
    }

    @Override
    public Reference update(String shortAddress, String fullAddress, int authorId) throws SQLException {
        Reference reference = null;
        String SQL = "UPDATE Reference SET short_address=?,full_address= ?, author_id=? where short_address = ?";
        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setString(1, shortAddress);
            statement.setString(2, fullAddress);
            statement.setInt(3, authorId);
            statement.setString(4, shortAddress);
            statement.executeUpdate();
            reference = getByShortAddress(shortAddress);
        }
        return reference;
    }

    @Override
    public void delete(String shortAddress) throws SQLException {
        String SQL = "DELETE FROM Statistics where ref_short_adr=?";
        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            statement.setString(1, shortAddress);
            statement.executeUpdate();
            SQL = "DELETE FROM Reference where short_address =?";
            PreparedStatement preparedStatement1 = connection.prepareStatement(SQL);
            preparedStatement1.setString(1, shortAddress);
            preparedStatement1.executeUpdate();
            preparedStatement1.close();
        }
    }*/

}
