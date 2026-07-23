package dao;

import config.DBConnection;
import model.Status;
import model.Transfer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransferDao {

    public static Transfer create(long sender_acc, long receiver_acc, Status status) throws SQLException {
            String sql = "insert into transferDetails(sender_account, receiver_account,status) values(?,?,?)";

            try (Connection conn = DBConnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS)
            ){
                pstmt.setLong(1, sender_acc);
                pstmt.setLong(2, receiver_acc);
                pstmt.setString(3, status.name());
                pstmt.executeUpdate();
                try (ResultSet keys = pstmt.getGeneratedKeys()){
                 keys.next();
                 Transfer transfer = findById(keys.getInt(1));
                 if (transfer == null){
                    throw new SQLException("Transfer with id " + keys.getInt(1) + " not found");
                 }
                 return transfer;
                }
            }
    }

    public static Transfer findById(long id) throws SQLException {
        String sql = "select * from transferDetails where id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)
        ){
            pstmt.setLong(1, id);
            try (ResultSet rs = pstmt.executeQuery()){
              return rs.next()?map(rs):null;
            }
        }

    }


    public static Transfer map(ResultSet rs) throws SQLException {
        return new Transfer(
                rs.getLong("sender_account"),
                rs.getLong("receiver_account"),
                Status.valueOf( rs.getString("status"))
                );
    }


}
