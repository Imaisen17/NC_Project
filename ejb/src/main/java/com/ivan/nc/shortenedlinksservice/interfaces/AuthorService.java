package com.ivan.nc.shortenedlinksservice.interfaces;

import com.ivan.nc.shortenedlinksservice.entity.Author;
import com.ivan.nc.shortenedlinksservice.entity.AuthorDTO;

import java.sql.SQLException;
import java.util.List;

public interface AuthorService {
    List<Author> getAll() throws SQLException;

    List<AuthorDTO> getAllWithRef() throws SQLException;

    Author getById(int id) throws SQLException;

    void create(String name) throws SQLException;

    void delete(int id) throws SQLException;


}
