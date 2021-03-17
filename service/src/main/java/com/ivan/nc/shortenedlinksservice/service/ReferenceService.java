package com.ivan.nc.shortenedlinksservice.service;

import com.ivan.nc.shortenedlinksservice.dao.ReferenceDAO;
import com.ivan.nc.shortenedlinksservice.dao.ReferenceDAOImpl;
import com.ivan.nc.shortenedlinksservice.model.Reference;

import java.sql.SQLException;
import java.util.List;

public class ReferenceService {
    private ReferenceDAO referenceDAO;

    public ReferenceService() {
        this.referenceDAO = new ReferenceDAOImpl();
    }

    public void show() {
        List<Reference> list = referenceDAO.getAll();
        System.out.println("List of References:");
        for (Reference reference :
                list) {
            System.out.println(reference.getAuthorId() + " " + reference.getShortAddress() + " " + reference.getFullAddress() + " " + reference.getDateCreate());
        }
    }

    public void showByShort_address(String short_address) {
        Reference reference = referenceDAO.getByShortAddress(short_address);
        System.out.println(reference.getAuthorId() + " " + reference.getShortAddress() + " " + reference.getFullAddress() + " " + reference.getDateCreate());
    }

    public void create(String fullAddress, int authorId) throws SQLException {
        referenceDAO.create(fullAddress,authorId);
    }

    public void update(String shortAddress, String fullAddress, int authorId) throws SQLException {
        referenceDAO.update(shortAddress,fullAddress, authorId);
    }
    public void delete(String shortAddress) throws SQLException {
        referenceDAO.delete(shortAddress);
    }
}
