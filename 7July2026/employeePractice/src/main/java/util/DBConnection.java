package util;

import java.sql.Connection;

public class DBConnection {
    private  String URL = "jdbc:mysql://localhost:3306/em";
    private  String USER = "root";
    private  String PASSWORD = "";

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = java.sql.DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

}
