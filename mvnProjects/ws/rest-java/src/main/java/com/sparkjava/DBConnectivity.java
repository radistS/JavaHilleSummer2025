package com.sparkjava;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnectivity {
    private static Connection connection;
    private static String serverTimeZone = "UTC";
    private static String servername = "localhost";
    private static String databaseName = "hillel";
    private static int databasePort = 3306;
    private static String user= "root";
    private static String password = "rootroot";

    public static Connection getConnection() throws SQLException {

        MysqlDataSource dataSource = new MysqlDataSource();

        dataSource.setUseSSL(false);
        dataSource.setServerTimezone(serverTimeZone);
        dataSource.setServerName(servername);
        dataSource.setDatabaseName(databaseName);
        dataSource.setPortNumber(databasePort);
        dataSource.setUser(user);
        dataSource.setPassword(password);

        return connection = dataSource.getConnection();

    }

    public static void closeConnection() throws SQLException {
        connection.close();
    }

}
