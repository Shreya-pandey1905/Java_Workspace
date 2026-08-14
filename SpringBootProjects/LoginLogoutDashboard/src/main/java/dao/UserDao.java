package dao;

import config.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public static void createUser(String name, String email, String hashedPass, String gender, String city){
        String sql= "insert into users (name, email,password, gender,city) values (?,?,?,?,?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1,name);
            statement.setString(2,email);
            statement.setString(3,hashedPass);
            statement.setString(4,gender);
            statement.setString(5,city);
            if (statement.executeUpdate()==1){
                System.out.println("User added");
            }else {
                System.out.println("User Creation Failed");
            };

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


    public static String findbyNameAndPassword(String email, String pwd) throws SQLException, ClassNotFoundException {
        String sql = "select * from users where email=? and password=?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setString(1, email);
            statement.setString(2, pwd);


            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("email");
                } else {
                    System.out.println("Not found");
                }
            }
        }
        return null;
    }


}

