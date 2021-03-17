package com.ivan.nc.shortenedlinksservice;

import com.ivan.nc.shortenedlinksservice.service.AuthorService;
import com.ivan.nc.shortenedlinksservice.service.ReferenceService;
import com.ivan.nc.shortenedlinksservice.view.Console;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        AuthorService authorService = new AuthorService();
        ReferenceService referenceService = new ReferenceService();
        Console console = new Console(authorService, referenceService);
        console.start();
    }
}
