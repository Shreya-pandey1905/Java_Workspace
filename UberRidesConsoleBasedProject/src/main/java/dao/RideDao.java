package dao;

import config.DBConnection;
import model.Ride;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RideDao {
//    public Ride create(long customerId, String pickup, String drop, BigDecimal fare) throws SQLException {
//        String sql = "insert into rides(customer_id, pickup_location, drop_location, fare , status) values(?,?,?,?,'REQUESTED')";
//
//        try (Connection connection = DBConnection.getConnection();
//             PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
//            statement.setLong(1, customerId);
//            statement.setString(2, pickup);
//            statement.setString(3, drop);
//            statement.setBigDecimal(4, fare);
//            statement.executeUpdate();
//
////            try(ResultSet keys = statement.getGeneratedKeys()){
////                keys.next();
////                Ride ride = findById(keys.getLong(1));
////                if (ride==null){
////                    throw new SQLException("Failed to loD NEWWLY CREATED Ride");
////                }
////                return  ride;
////            }
//        }
//    }
}
