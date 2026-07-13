package dao;

import config.DBConnection;
import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDao {
    //TODO:REGISTER CUSTOMER

    public Customer create(String name , String email, String phone , String passwordHash) throws SQLException {
        String sql = "insert into customers (name, email , phone , password_hash) values(?,?,?,?)";
        try(Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection .prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS)// retreival key
           )
        //TODO: RETURN GENERATED KEYS -> TO MAKE AUTO GENERATED KEYS RETRIEVVAL
        {
            statement.setString(1,name);
            statement.setString(2,email);
            statement.setString(3,phone);
            statement.setString(4,passwordHash);

            statement.executeUpdate();
            try (ResultSet keys = statement.getGeneratedKeys()){// last_insert_id work like in sql
                keys.next();
                Customer customer = findByID(keys.getLong(1));
                if (customer==null){
                    throw new SQLException("Failed to load newly created customer");
                }
                return customer;
            }
        }
    }


    //after insertion of the customers
    public Customer findByID(long id) throws SQLException{
        String sql="select * from customers where id=?"; //3

        try(Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)
        ){
            statement.setLong(1,id);
            try(ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next()? map(resultSet): null;
            }
        }
    }

    public Customer findByEmailAndPassword(String email, String password) throws SQLException{
        String sql="select * from customers where email=? and password_hash=?";
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

    private Customer map(ResultSet resultSet) throws SQLException{
        return new Customer(
                resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getString("email"),
                resultSet.getString("phone")

        );
    }


}
