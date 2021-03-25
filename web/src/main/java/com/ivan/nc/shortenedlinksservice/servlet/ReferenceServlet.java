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
import java.util.List;

public class ReferenceServlet extends HttpServlet {
    private int id;
    @EJB
    ReferenceService referenceService;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("id"));
        id = Integer.valueOf(req.getParameter("id"));
        System.out.println(id);
        List<Reference> referenceList;
        referenceList = referenceService.getAllById(id);
        req.setAttribute("referenceList", referenceList);
        req.getRequestDispatcher("WEB-INF/references.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String shortAddress = req.getParameter("delete");
        try {
            System.out.println("Tryyy");
            //Reference reference = referenceService.showByShort_address(shortAddress);
            System.out.println(shortAddress);
            referenceService.delete(shortAddress);
            resp.sendRedirect("reference?id=" + id);
            System.out.println(id + "");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
