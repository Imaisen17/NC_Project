package com.ivan.nc.shortenedlinksservice.servlet;

import com.ivan.nc.shortenedlinksservice.entity.Reference;
import com.ivan.nc.shortenedlinksservice.interfaces.ReferenceService;


import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ReferenceRedirect extends HttpServlet {

    @EJB
    ReferenceService referenceService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String shortAddress = req.getParameter("shortAddress");
        Reference reference;
        reference = referenceService.getByShortAddress(shortAddress);
        req.setAttribute("reference", reference);
        resp.sendRedirect(reference.getFullAddress());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
