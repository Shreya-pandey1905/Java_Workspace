package org.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws Exception {
        String driver = "com.mysql.cj.jdbc.Driver";
        String jdbc_url="jdbc:mysql://localhost:3307/jdbc";

        String user= "root";
        String pwd="";
        String sql_query = "create table emp(id int , name varchar(50),salary double, addr varchar(100))";

        Class.forName(driver);

        Connection conn = DriverManager.getConnection(jdbc_url,user,pwd);
        Statement st = conn.createStatement();
        st.executeUpdate(sql_query);
        System.out.println("Table created successfully");
        conn.close();
    }
}
