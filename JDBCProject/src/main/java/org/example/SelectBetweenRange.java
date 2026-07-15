package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SelectBetweenRange {
    public  static void main(String[] args) throws Exception{

        String driver = "com.mysql.cj.jdbc.Driver";
        String jdbc_url="jdbc:mysql://localhost:3307/jdbc";
        String user= "root";
        String pwd="";

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the lower range ");
        double lowsal = sc.nextDouble();
        System.out.println("Enter the higher range");
        double highsal = sc.nextDouble();



        String sql_query2 = String.format("select * from emp where salary between %f and %f ",lowsal,highsal);
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(jdbc_url,user,pwd);
        Statement st = conn.createStatement();
       ResultSet rs =st.executeQuery(sql_query2);
        while (rs.next()){
            System.out.println(rs.getInt(1)+".."+ rs.getString(2)+".."+rs.getDouble(3)+".."+rs.getString(4));
        }

        System.out.println("Query executed");
        conn.close();


    }

}
