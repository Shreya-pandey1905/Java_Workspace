package org.example;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;



public class PrintSal {

    public static void main(String[] args) throws Exception {

        String driver = "com.mysql.cj.jdbc.Driver";
        String jdbc_url = "jdbc:mysql://localhost:3307/jdbc";
        String user = "root";
        String pwd = "";

        Class.forName(driver);

        Connection conn = DriverManager.getConnection(jdbc_url, user, pwd);


        CallableStatement cs = conn.prepareCall("{call PRINTSAL(?,?)}");
        cs.setInt(1,1);

        cs.registerOutParameter(2, Types.INTEGER);

        cs.execute();
        System.out.println(cs.getInt(2));

        System.out.println("Query Exceuted successfully.");

        cs.execute();


        conn.close();
        cs.close();
    }
}
