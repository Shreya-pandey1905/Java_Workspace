package org.example;

import java.lang.reflect.Type;
import java.sql.*;
import java.util.Scanner;

public class ProcedureCall {

    public static void main(String[] args) throws Exception {

        String driver = "com.mysql.cj.jdbc.Driver";
        String jdbc_url = "jdbc:mysql://localhost:3307/jdbc";
        String user = "root";
        String pwd = "";

        Class.forName(driver);

        Connection conn = DriverManager.getConnection(jdbc_url, user, pwd);


               CallableStatement cs = conn.prepareCall("{call JDBCTEST(?,?,?)}");
        cs.setInt(1, 100);
        cs.setInt(2, 200);
        cs.registerOutParameter(3, Types.INTEGER);

        cs.execute();
        System.out.println(cs.getInt(3));

        System.out.println("Query Exceuted successfully.");

        cs.execute();


        conn.close();
     cs.close();
    }
}
