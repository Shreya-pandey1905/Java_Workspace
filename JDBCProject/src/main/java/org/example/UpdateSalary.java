package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateSalary {
    public  static void main(String[] args) throws Exception{

        String driver = "com.mysql.cj.jdbc.Driver";
        String jdbc_url="jdbc:mysql://localhost:3307/jdbc";
        String user= "root";
        String pwd="";

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the salary to be increased");
        double updateSalary = sc.nextDouble();

        System.out.println("Check the salary limmit");
        double existSalary= sc.nextDouble();

        String sql_query2 = String.format("update emp set salary=salary+%f where salary<=%f",updateSalary,existSalary);
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(jdbc_url,user,pwd);
        Statement st = conn.createStatement();
        int result=st.executeUpdate(sql_query2);
        System.out.println("data updated  successfully");
        System.out.println("no of rows afffeted "+ result);
        conn.close();


    }
}
