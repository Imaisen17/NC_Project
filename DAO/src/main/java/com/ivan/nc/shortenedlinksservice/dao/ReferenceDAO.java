package com.ivan.nc.shortenedlinksservice.dao;

import com.ivan.nc.shortenedlinksservice.model.Reference;

import java.sql.SQLException;
import java.util.List;

public interface ReferenceDAO {
    List<Reference> getAll();

    Reference getByShortAddress(String short_address);

    void create(String fullAddress, int authorId) throws SQLException;

    Reference update(String shortAddress, String fullAddress, int authorId) throws SQLException;

    void delete(String shortAddress) throws SQLException;
}
