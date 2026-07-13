package dao;

import config.DBConnection;
import model.Customer;
import model.Driver;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DriverDao {
    //TODO: REGISTER DRIVER
    public Driver create(String name , String email, String phone, String passwordHash, String vehicleNo, String currentLocation, Boolean available, BigDecimal rating) throws SQLException {
        String sql = "insert into drivers (name,email,phone,password_hash,vehicle_no,current_location,available,rating) values(?,?,?,?,?,?,?,?)";        try(Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection .prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS))
        {
            statement.setString(1,name);
            statement.setString(2,email);
            statement.setString(3,phone);
            statement.setString(4,passwordHash);
            statement.setString(5,vehicleNo);
            statement.setString(6,currentLocation);
            statement.setBoolean(7,available);
            statement.setBigDecimal(8,rating);

            statement.executeUpdate();

            try(ResultSet keys = statement.getGeneratedKeys()){
                keys.next();
                Driver driver = findByID(keys.getLong(1));
                if (driver==null){
                    throw new SQLException("Failed to insert driver");
                }
                return driver;
            }
        }
    }
    public Driver findByID(long id) throws SQLException{
        String sql="select * from drivers where id=?";

        try(Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)
        ){
            statement.setLong(1,id);
            try(ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next()? map(resultSet): null;
            }
        }
    }

    public Driver findByEmailAndPassword(String email, String password) throws SQLException{
        String sql="select * from drivers where email=? and password_hash=?";
        try(Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)
        ){
            statement.setString(1,email);
            statement.setString(2,password);
            try(ResultSet resultSet = statement.executeQuery()){
                return resultSet.next()? map(resultSet):null;
            }
        }
    }

    private Driver map(ResultSet resultSet) throws SQLException{
        return new Driver(
                resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getString("email"),
                resultSet.getString("phone"),
                resultSet.getString("vehicle_no"),
                resultSet.getString("current_location"),
                resultSet.getBoolean("available"),
                resultSet.getBigDecimal("rating")

        );
    }



}
