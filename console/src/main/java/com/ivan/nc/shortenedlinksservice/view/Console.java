package com.ivan.nc.shortenedlinksservice.view;

import com.ivan.nc.shortenedlinksservice.model.Statistics;
import com.ivan.nc.shortenedlinksservice.service.AuthorService;
import com.ivan.nc.shortenedlinksservice.service.ReferenceService;
import com.ivan.nc.shortenedlinksservice.service.StatisticsService;
import com.ivan.nc.shortenedlinksservice.util.DbConnection;

import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class Console {
    private AuthorService authorService;
    private ReferenceService referenceService;
    private StatisticsService statisticsService;

    public Console(AuthorService authorService, ReferenceService referenceService, StatisticsService statisticsService) {
        this.authorService = authorService;
        this.referenceService = referenceService;
        this.statisticsService = statisticsService;
    }

    public Console(ReferenceService referenceService) {
        this.referenceService = referenceService;
    }

    public Console(AuthorService authorService) {
        this.authorService = authorService;
    }

    public Console(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    public void start() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Date date = new Date();
        boolean reload = true;
        while (reload){
            System.out.println("Выберите одно из действий -" + "\n" +
                    "1: Вывод автора по Id" + "\n" +
                    "2: Вывод всех авторов" + "\n" +
                    "3: Вывод ссылки по короткой ссылке" + "\n" +
                    "4: Вывод всех ссылок" + "\n" +
                    "5: Создание автора" + "\n" +
                    "6: Создание ссылки" + "\n" +
                    "7: Обновление автора" + "\n" +
                    "8: Обновление ссылки" + "\n" +
                    "9: Удаление автора" + "\n" +
                    "10: Удаление ссылки" +"\n"+
                    "11: Exit" + "\n" +
                    "--------------------------------------");
            switch (scanner.nextInt()) {
                case 1: {
                    System.out.println("Enter Author id\n");
                    authorService.showById(scanner.nextInt());
                }
                break;
                case 2: {
                    System.out.println("List of Authors\n___________________");
                    authorService.show();
                    System.out.println("________________________\n");
                }
                break;
                case 3: {
                    System.out.println("Enter short id");
                    referenceService.showByShort_address(scanner.next());
                }
                break;
                case 4: {
                    System.out.println("List of References\n____________________");
                    referenceService.show();
                    System.out.println("++++++++++++++++++++++++\n");
                }
                break;
                case 5: {
                    System.out.println("Enter Author name\n");
                    authorService.create(scanner.next());
                }
                break;
                case 6: {
                    System.out.println("Enter full address and Author id\n");
                    referenceService.create(scanner.next(), scanner.nextInt());
                }
                break;
                case 7: {
                    System.out.println("Enter Author id and his new name\n");
                    authorService.update(scanner.nextInt(), scanner.next());
                }
                break;
                case 8: {
                    System.out.println("Enter Reference short address, full address and Author id\n ");
                    referenceService.update(scanner.next(), scanner.next(), scanner.nextInt());
                }
                break;
                case 9:{
                    System.out.println("Enter Author id that should be deleted\n");
                    authorService.delete(scanner.nextInt());
                }break;
                case 10:{
                    System.out.println("Enter Short Address of Reference which should be deleted\n");
                    referenceService.delete(scanner.next());
                }break;
                case 11: {
                    System.out.println("Exiting\n");
                    DbConnection.closeConnection();
                    reload = false;
                }break;
                case 12:{
                    statisticsService.showByAuthorId(scanner.nextInt());
                }break;
                default: {
                    System.out.println("Incorrect choice! Try again!");
                }

            }


    }
}}
