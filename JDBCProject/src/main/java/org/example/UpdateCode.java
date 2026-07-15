package org.example;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateCode {
    public static void main(String[] args) throws Exception {
        String driver = "com.mysql.cj.jdbc.Driver";
        String jdbc_url="jdbc:mysql://localhost:3307/jdbc";

        String user= "root";
        String pwd="";
        String sql_query2 = "update emp set addr ='kandivli' where id = 6";
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(jdbc_url,user,pwd);
        Statement st = conn.createStatement();
        int result=st.executeUpdate(sql_query2);
        System.out.println("data updated  successfully");
        System.out.println("no of rows afffeted "+ result);
        conn.close();
    }
}
