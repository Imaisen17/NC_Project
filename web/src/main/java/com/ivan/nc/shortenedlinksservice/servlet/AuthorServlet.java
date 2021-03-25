package com.ivan.nc.shortenedlinksservice.servlet;

import com.ivan.nc.shortenedlinksservice.entity.AuthorDTO;
import com.ivan.nc.shortenedlinksservice.entity.Author;
import com.ivan.nc.shortenedlinksservice.interfaces.AuthorService;


import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AuthorServlet extends HttpServlet {

    @EJB
    AuthorService authorService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Author> authorList;
        {
            try {
                authorList = authorService.getAll();
                req.setAttribute("authorList", authorList);
                req.getRequestDispatcher("WEB-INF/author.jsp").forward(req, resp);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int authorId = Integer.valueOf(req.getParameter("delete"));
        try {
            Author author = authorService.getById(authorId);
            authorService.delete(authorId);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        resp.sendRedirect("author");
    }


}
