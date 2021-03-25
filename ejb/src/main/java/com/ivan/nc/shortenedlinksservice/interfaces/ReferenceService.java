package com.ivan.nc.shortenedlinksservice.interfaces;

import com.ivan.nc.shortenedlinksservice.entity.Reference;

import java.sql.SQLException;
import java.util.List;

public interface ReferenceService {
    List<Reference> getAll();

    List<Reference> getAllById(int id);

    Reference getByShortAddress(String short_address);
    Reference getByFullAddress(String full_address);

    void create(String fullAddress, int authorId) throws SQLException;

    Reference update(String shortAddress, String fullAddress, int authorId) throws SQLException;

    void delete(String shortAddress) throws SQLException;
}
