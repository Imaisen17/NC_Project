package com.ivan.nc.shortenedlinksservice.servlet;

import com.ivan.nc.shortenedlinksservice.DTO.AuthorDTO;
import com.ivan.nc.shortenedlinksservice.dao.AuthorDAO;
import com.ivan.nc.shortenedlinksservice.dao.AuthorDAOImpl;
import com.ivan.nc.shortenedlinksservice.service.AuthorService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AuthorAdd extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AuthorService authorService = new AuthorService();
        List<AuthorDTO> authorList;
        {
            try {
                authorList = authorService.show();
                req.setAttribute("authorList", authorList);
                req.getRequestDispatcher("WEB-INF/newAuthor.jsp").forward(req,resp);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String authorName = req.getParameter("authorName");
        AuthorDAO authorDAO = new AuthorDAOImpl();
        try {
            authorDAO.create(authorName);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        resp.sendRedirect("/author");

    }
}
