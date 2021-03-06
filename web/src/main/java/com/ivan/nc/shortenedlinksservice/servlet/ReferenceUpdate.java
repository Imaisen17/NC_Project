package com.ivan.nc.shortenedlinksservice.servlet;

import com.ivan.nc.shortenedlinksservice.entity.Reference;
import com.ivan.nc.shortenedlinksservice.interfaces.ReferenceService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ReferenceUpdate extends HttpServlet {
    String shortAddress;
    @EJB
    ReferenceService referenceService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        shortAddress = req.getParameter("shortAddress");
        req.setAttribute("shortAddress", shortAddress);
        Reference reference=referenceService.getByShortAddress(shortAddress);
        req.setAttribute("reference", reference);
        req.getRequestDispatcher("WEB-INF/referenceUpdate.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        //shortAddress = req.getParameter("shortAddress");
        String fullAddress = req.getParameter("fullAddress");
        int authorId = Integer.valueOf(req.getParameter("authorId"));
        //Date dateCreate = Date.valueOf(req.getParameter("dateCreate"));
        Reference reference = new Reference(fullAddress, shortAddress, authorId);
        try {
            referenceService.update(shortAddress,fullAddress, authorId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        resp.sendRedirect("referenceUpdate?shortAddress="+shortAddress);
    }
}
