package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BalanceTransaction {

    public static void main(String[] args) throws Exception {
        try (Connection conn = DBConnection.connection()) {
            conn.setAutoCommit(false);
            try (PreparedStatement ps = conn.prepareStatement("update accounts set balance=balance-? where id=?");
                 PreparedStatement ps2 = conn.prepareStatement("update accounts set balance =balance+? where id =?");) {
                ps.setInt(1, 5000);
                ps.setInt(2,1);


                ps2.setInt(1, 5000);
                ps2.setInt(2,2);

                ps.executeUpdate();
                ps2.executeUpdate();
                conn.commit();
                System.out.println("Account Updated");

            }
            catch (Exception e){
                conn.rollback();
            }

        }
    }
}