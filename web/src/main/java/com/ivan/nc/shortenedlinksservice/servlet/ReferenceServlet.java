package com.ivan.nc.shortenedlinksservice.servlet;

import com.ivan.nc.shortenedlinksservice.DTO.AuthorDTO;
import com.ivan.nc.shortenedlinksservice.model.Reference;
import com.ivan.nc.shortenedlinksservice.service.AuthorService;
import com.ivan.nc.shortenedlinksservice.service.ReferenceService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ReferenceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       int id = Integer.valueOf(req.getParameter("id"));
        ReferenceService referenceService = new ReferenceService();
        List<Reference> referenceList;
            referenceList = referenceService.showById(id);
            req.setAttribute("referenceList", referenceList);
            req.getRequestDispatcher("WEB-INF/references.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
