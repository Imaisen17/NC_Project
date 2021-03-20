package com.ivan.nc.shortenedlinksservice.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/ncdb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static Connection connection = null;

  /*  static {

    }
*/
    public static Connection getConnection(){
        try{
            if(connection==null){
                Class.forName ("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(URL,USER,PASSWORD) ;
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }return connection;
    }

    public static void closeConnection() throws SQLException {
        connection.close();

    }

}
