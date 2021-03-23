package com.ivan.nc.shortenedlinksservice.servlet;

import com.ivan.nc.shortenedlinksservice.DTO.AuthorDTO;
import com.ivan.nc.shortenedlinksservice.model.Author;
import com.ivan.nc.shortenedlinksservice.service.AuthorService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AuthorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AuthorService authorService = new AuthorService();
        List<AuthorDTO> authorList;
        {
            try {
                authorList = authorService.show();
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
            AuthorService authorService = new AuthorService();
            Author author = authorService.showById(authorId);
            authorService.delete(authorId);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        resp.sendRedirect("author");
    }


}
