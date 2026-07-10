package org.example;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DynamicQuery {
    public  static void main(String[] args) throws Exception{

        String driver = "com.mysql.cj.jdbc.Driver";
        String jdbc_url="jdbc:mysql://localhost:3307/jdbc";
        String user= "root";
        String pwd="";

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the query ");
String userQuery= sc.nextLine();



        Class.forName(driver);
        Connection conn = DriverManager.getConnection(jdbc_url,user,pwd);
        Statement st = conn.createStatement();
        boolean sql_query2 = st.execute(userQuery);
        if (sql_query2){
           ResultSet rs= st.getResultSet();
            while (rs.next()){
                System.out.println(rs.getInt(1)+".."+ rs.getString(2)+".."+rs.getDouble(3)+".."+rs.getString(4));
            }

        }
        else {
            st.getUpdateCount();
        }

      // execute() if true-> select , if false non select query
        System.out.println("Query executed successfully");

        conn.close();


    }

}

