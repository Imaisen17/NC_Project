package com.ivan.nc.shortenedlinksservice.servlet;

import com.ivan.nc.shortenedlinksservice.entity.Reference;
import com.ivan.nc.shortenedlinksservice.interfaces.ReferenceService;
import com.ivan.nc.shortenedlinksservice.interfaces.StatisticsService;


import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ReferenceRedirect extends HttpServlet {

    @EJB
    ReferenceService referenceService;

    @EJB
    StatisticsService statisticsService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String shortAddress = req.getParameter("shortAddress");
        int id = Integer.valueOf(req.getParameter("authorId"));
        Reference reference;
        reference = referenceService.getByShortAddress(shortAddress);
        req.setAttribute("reference", reference);
        statisticsService.createStat(id,shortAddress, 1);
        resp.sendRedirect(reference.getFullAddress());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
