package dao;

import config.DBConnection;
import model.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao {
public Admin findByEmailAndPassword(String email, String passwordHash) throws SQLException {
    String sql = "select * from admins where email=? and password_hash=?";
    try (Connection connection = DBConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)
    ) {
        statement.setString(1, email);
        statement.setString(2, passwordHash);
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                return new Admin(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email")
                );
            }
            return null;

        }
    }
}
}
