package config;

import  java.sql.*;
    public final class DBConnection {

        private static final String jdbc_url = "jdbc:mysql://localhost:3306/uberrides?allowPublicKeyRetrieval=true";
        private static final String user = "root";
        private static final String pwd = "";

        public static Connection getConnection() throws SQLException{

            Connection conn = DriverManager.getConnection(jdbc_url, user, pwd);


            return conn;

        }
    }




