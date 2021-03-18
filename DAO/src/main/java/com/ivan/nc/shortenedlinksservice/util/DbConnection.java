package com.ivan.nc.shortenedlinksservice.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private static final String URL = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
    private static final String USER = "user1";
    private static final String PASSWORD = "111";

    private static Connection connection = null;

  /*  static {

    }
*/
    public static Connection getConnection(){
        try{
            if(connection==null){
                Class.forName ("oracle.jdbc.driver.OracleDriver");
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
