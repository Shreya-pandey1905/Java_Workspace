package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteOnCondition {
    public  static void main(String[] args) throws Exception{
        Connection conn =   DBConnection.connection();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the salary ");
        double sal = sc.nextDouble();


        String sql_query2 = String.format("delete from emp where salary<=%.2f",sal);

        Statement st = conn.createStatement();
        int result=st.executeUpdate(sql_query2);
        System.out.println("data updated  successfully");
        System.out.println("no of rows afffeted "+ result);
        conn.close();


    }

}
