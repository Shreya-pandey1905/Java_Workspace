package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConnection {

    private static final String jdbc_url = "jdbc:mysql://localhost:3307/filehandling?allowPublicKeyRetrieval=true";
    private static final String user = "root";
    private static final String pwd = "";

    public static Connection getConnection() throws SQLException {

        Connection conn = DriverManager.getConnection(jdbc_url, user, pwd);


        return conn;

    }
}


