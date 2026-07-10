package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class InsertUsingPs {

    public static void main(String[] args) throws Exception {

        String driver = "com.mysql.cj.jdbc.Driver";
        String jdbc_url = "jdbc:mysql://localhost:3307/jdbc";
        String user = "root";
        String pwd = "";

        Class.forName(driver);

        Connection conn = DriverManager.getConnection(jdbc_url, user, pwd);

        Scanner sc = new Scanner(System.in);

        int userInsert = 1;

        while (userInsert == 1) {

            System.out.println("Enter ID:");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter Name:");
            String name = sc.nextLine();

            System.out.println("Enter Salary:");
            double salary = sc.nextDouble();
            sc.nextLine();

            System.out.println("Enter Address:");
            String addr = sc.nextLine();

            PreparedStatement ps = conn.prepareStatement( "insert into emp values(?,?,?,?)");
            ps.setInt(1,id);
            ps.setString(2,name);
            ps.setDouble(3,salary);
            ps.setString(4,addr);
            int result=ps.executeUpdate();



            System.out.println("Data inserted successfully.");
            System.out.println("Rows affected: " + result);


            ps.close();

            System.out.println("Press 1 to insert more");
            userInsert = sc.nextInt();


        }

        conn.close();
        sc.close();
    }
}