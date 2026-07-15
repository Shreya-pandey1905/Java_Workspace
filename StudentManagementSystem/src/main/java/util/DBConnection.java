package util;
import  java.sql.*;
    public class DBConnection {
        public static Connection connection() throws Exception {


            String driver = "com.mysql.cj.jdbc.Driver";
            String jdbc_url = "jdbc:mysql://localhost:3307/jdbc";
            String user = "root";
            String pwd = "";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(jdbc_url, user, pwd);


            return conn;

        }
    }


