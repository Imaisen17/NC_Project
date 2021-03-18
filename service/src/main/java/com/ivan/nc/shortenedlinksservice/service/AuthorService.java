package com.ivan.nc.shortenedlinksservice.service;

import com.ivan.nc.shortenedlinksservice.DTO.AuthorDTO;
import com.ivan.nc.shortenedlinksservice.dao.AuthorDAO;
import com.ivan.nc.shortenedlinksservice.dao.AuthorDAOImpl;
import com.ivan.nc.shortenedlinksservice.model.Author;

import java.sql.SQLException;
import java.util.List;

public class AuthorService {

    private AuthorDAO authorDAO;

    public AuthorService() {
        this.authorDAO = new AuthorDAOImpl();
    }

    public List<AuthorDTO> show() throws SQLException {
        List<AuthorDTO> list = authorDAO.getAllWithRef();
        return list;
    }

    public void showById(int id) throws SQLException {
        Author author = authorDAO.getById(id);
        System.out.println(author.getId() + author.getName());
    }

    public void create(String name) throws SQLException {
        authorDAO.create(name);
    }

    public void update(int id, String name) throws SQLException {
        authorDAO.update(id, name);
    }

    public void delete(int id) throws SQLException {
        authorDAO.delete(id);
    }

}
