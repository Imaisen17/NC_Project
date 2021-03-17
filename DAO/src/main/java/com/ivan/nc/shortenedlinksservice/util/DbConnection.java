package com.ivan.nc.shortenedlinksservice.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private static final String URL = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
    private static final String USER = "user1";
    private static final String PASSWORD = "111";

    private static Connection connection = null;

    static {
        try{
           connection = DriverManager.getConnection(URL,USER,PASSWORD) ;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return connection;
    }

    public static void closeConnection() throws SQLException {
        connection.close();

    }

}
