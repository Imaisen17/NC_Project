package com.ivan.nc.shortenedlinksservice.servlet;

import com.ivan.nc.shortenedlinksservice.DTO.AuthorDTO;
import com.ivan.nc.shortenedlinksservice.dao.AuthorDAO;
import com.ivan.nc.shortenedlinksservice.dao.AuthorDAOImpl;
import com.ivan.nc.shortenedlinksservice.dao.ReferenceDAO;
import com.ivan.nc.shortenedlinksservice.dao.ReferenceDAOImpl;
import com.ivan.nc.shortenedlinksservice.model.Author;
import com.ivan.nc.shortenedlinksservice.model.Reference;
import com.ivan.nc.shortenedlinksservice.model.Statistics;
import com.ivan.nc.shortenedlinksservice.service.AuthorService;
import com.ivan.nc.shortenedlinksservice.service.ReferenceService;
import com.ivan.nc.shortenedlinksservice.service.StatisticsService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ReferenceServlet extends HttpServlet {
private int id;
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("id"));
        id = Integer.valueOf(req.getParameter("id"));
        System.out.println(id);
        ReferenceService referenceService = new ReferenceService();
        List<Reference> referenceList;
            referenceList = referenceService.showById(id);
            req.setAttribute("referenceList", referenceList);
            req.getRequestDispatcher("WEB-INF/references.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String shortAddress = req.getParameter("delete");
        try {
            System.out.println("Tryyy");
            ReferenceService referenceService = new ReferenceService();
            //Reference reference = referenceService.showByShort_address(shortAddress);
            System.out.println(shortAddress);
            referenceService.delete(shortAddress);
            resp.sendRedirect("reference?id="+id);
            System.out.println(id+"");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
