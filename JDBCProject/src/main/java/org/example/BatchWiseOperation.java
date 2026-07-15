package org.example;

import java.sql.Connection;
import java.sql.Statement;

public class BatchWiseOperation{
    public static void main(String[] args) throws Exception{
        Connection conn =   DBConnection.connection();
        Statement st = conn.createStatement();
        st.addBatch("insert into emp values(7,'Jatin',60000,'Pune')");
        st.addBatch("update emp set salary =55000 where id=4");
        st.addBatch("delete from emp where id=6");

       int[] count= st.executeBatch();
        int sum=0;
      for(int i=0; i< count.length;i++){

          sum+=i;

      }
        System.out.println("This many rows got affected"+sum);


    }
}
