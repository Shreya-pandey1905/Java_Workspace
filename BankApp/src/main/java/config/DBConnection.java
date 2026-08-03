package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConnection {

    private static final String jdbc_url = "jdbc:mysql://localhost:3307/bank?allowPublicKeyRetrieval=true";
    private static final String user = "root";
    private static final String pwd = "";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL Driver not found", e);
        }

        return DriverManager.getConnection(jdbc_url, user, pwd);
    }
}


