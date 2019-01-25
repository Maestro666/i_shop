package ua.com.fok.utils;

import org.apache.log4j.xml.DOMConfigurator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
    private static String USER_NAME = "root";
    private static String USER_PASSWORD = "root";
    private  static String URL = "jdbc:mysql://localhost/i_shop";

    public static Connection  openConnection() throws ClassNotFoundException, SQLException {
        DOMConfigurator.configure("loggerConfig.xml");
        Class.forName ("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection (URL, USER_NAME, USER_PASSWORD);
    }
}