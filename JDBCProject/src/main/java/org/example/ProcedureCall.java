package org.example;

import java.sql.*;

public class ProcedureCall {

    public static void main(String[] args) throws Exception {


        Connection conn =   DBConnection.connection();


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
