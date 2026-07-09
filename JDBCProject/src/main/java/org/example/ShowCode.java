package org.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ShowCode {
    public static void main(String[] args) throws Exception {
        String driver = "com.mysql.cj.jdbc.Driver";
        String jdbc_url="jdbc:mysql://localhost:3307/jdbc";

        String user= "root";
        String pwd="";
        Class.forName(driver);

        Connection conn = DriverManager.getConnection(jdbc_url,user,pwd);
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from emp");

        while (rs.next()){
            System.out.println(rs.getInt(1)+".."+ rs.getString(2)+".."+rs.getDouble(3)+".."+rs.getString(4));
        }
        conn.close();
    }
}
