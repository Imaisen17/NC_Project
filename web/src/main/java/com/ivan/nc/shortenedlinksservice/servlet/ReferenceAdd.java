package com.ivan.nc.shortenedlinksservice.servlet;

import com.ivan.nc.shortenedlinksservice.dao.ReferenceDAO;
import com.ivan.nc.shortenedlinksservice.dao.ReferenceDAOImpl;
import com.ivan.nc.shortenedlinksservice.model.Reference;
import com.ivan.nc.shortenedlinksservice.service.ReferenceService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ReferenceAdd extends HttpServlet {
private int id;
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/newReference.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String fullAddress = req.getParameter("fullAddress");
        int authorId = Integer.parseInt(req.getParameter("authorId"));
        ReferenceDAO referenceDAO = new ReferenceDAOImpl();
        try {
            referenceDAO.create(fullAddress, authorId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        resp.sendRedirect("author");
    }
}
