package com.ivan.nc.shortenedlinksservice.dao;

import com.ivan.nc.shortenedlinksservice.DTO.AuthorDTO;
import com.ivan.nc.shortenedlinksservice.model.Author;

import java.sql.SQLException;
import java.util.List;

public interface AuthorDAO {
    List<Author> getAll() throws SQLException;
    List<AuthorDTO> getAllWithRef() throws SQLException;

    Author getById(int id) throws SQLException;

    void create(String name) throws SQLException;

    Author update(int id, String name) throws SQLException;

    void delete(int id) throws SQLException;


}
