package dao;

import config.DBConnection;
import model.AuditLogs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuditDao {

    public static void create(String email,String action, String description) throws SQLException {

        String sql ="insert into audit_logs(email, action, description)values(?,?,?)";

        try(Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)){

            statement.setString(1, email);
            statement.setString(2, action);
            statement.setString(3, description);

            statement.executeUpdate();
        }
    }

    public static List<AuditLogs> viewAudits(String email) throws SQLException {

        List<AuditLogs> list = new ArrayList<>();

        String sql = "select * from audit_logs where email=?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, email);

            try (ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    list.add(map(resultSet));
                }
            }
        }

        return list;
    }

    public static AuditLogs map(ResultSet resultSet) throws SQLException {

        return new AuditLogs(
                resultSet.getInt("id"),
                resultSet.getString("email"),
                resultSet.getString("action"),
                resultSet.getString("description")
                );
    }



}
