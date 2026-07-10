package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class FindMaxSal {
    public  static void main(String[] args) throws Exception{

        String driver = "com.mysql.cj.jdbc.Driver";
        String jdbc_url="jdbc:mysql://localhost:3307/jdbc";
        String user= "root";
        String pwd="";

        Scanner sc = new Scanner(System.in);



        String sql_query2 = String.format("select max(salary) from emp");
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(jdbc_url,user,pwd);
        Statement st = conn.createStatement();
        ResultSet rs =st.executeQuery(sql_query2);
        if (rs.next()){
            System.out.println(rs.getInt(1));
        }

        System.out.println("Query executed");
        conn.close();


    }

}
