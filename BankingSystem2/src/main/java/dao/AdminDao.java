package dao;

import config.DBConnection;
import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class AdminDao {

    public static Users login(String email, String password) throws SQLException {

        String sql = "select * from users where email=? and password=? and role='ADMIN'";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, email);
            statement.setString(2, password);

            try (ResultSet resultSet = statement.executeQuery()) {

                return resultSet.next() ? map(resultSet) : null;
            }
        }
    }

    private static Users map(ResultSet resultSet) throws SQLException {

        return new Users(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("email"),
                resultSet.getLong("account_no"),
                resultSet.getString("ifsc"),
                resultSet.getString("branch"),
                resultSet.getString("role"),
                resultSet.getDouble("balance"),
                resultSet.getBoolean("user_lock"),
                resultSet.getInt("attempts")
        );
    }

    public static List<Users> findAllUsers() throws SQLException {
        String sql = "select * from users where role='USER'";

        List<Users> users = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                users.add(map(resultSet));
            }
        }
        return users;
    }

    public static List<Transactions> findAllTransactions() throws SQLException {

        String sql = "select * from transactions";

        List<Transactions> transactions = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {

                Transactions transaction = new Transactions(
                        resultSet.getInt("user_id"),
                        Type.valueOf(resultSet.getString("type")),
                        resultSet.getDouble("amount"),
                        resultSet.getDouble("balance_after"),
                        Status.valueOf(resultSet.getString("status")),
                        resultSet.getString("reason")
                );

                transactions.add(transaction);
            }
        }

        return transactions;
    }

    public static List<Transactions> AllfailTransactions() throws SQLException {
        String sql = "select * from transactions where status = 'FAILED'";
        List<Transactions> transactions = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Transactions transaction = new Transactions(
                        resultSet.getInt("userid"),
                        Type.valueOf(resultSet.getString("type")),
                        resultSet.getDouble("amount"),
                        resultSet.getDouble("balanceafter"),
                        Status.valueOf(resultSet.getString("status")),
                        resultSet.getString("reason")
                );
                transactions.add(transaction);
            }
        }
        return transactions;
    }

    public static List<Users> highestBalanceUser() throws SQLException {
        String sql = "select * from users where role='USER' AND balance = (select MAX(balance) from users)";
        List<Users> users = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                users.add(map(resultSet));
            }
        }
        return users;
    }

    public static List<Transactions> transactionBetweenDate(String start,String end) throws SQLException {
        String sql = "select * from transactions where created_at BETWEEN ? AND ?";
        List<Transactions> transactions = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, start);
            statement.setString(2, end);

           try (ResultSet resultSet = statement.executeQuery())
        {

            while (resultSet.next()) {
                Transactions transaction = new Transactions(
                        resultSet.getInt("user_id"),
                        Type.valueOf(resultSet.getString("type")),
                        resultSet.getDouble("amount"),
                        resultSet.getDouble("balance_after"),
                        Status.valueOf(resultSet.getString("status")),
                        resultSet.getString("reason")
                );
                transactions.add(transaction);
            }

        }
           }
        return transactions;
    }

    public static void unlockUserr(int id) throws SQLException {
        String sql = "update users set user_lock=false where id=? ";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        }
    }

    public static List<AuditLogs> viewAudits() throws SQLException {

        List<AuditLogs> list = new ArrayList<>();

        String sql = "select * from audit_logs";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            try (ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {

                    AuditLogs auditLogs = new AuditLogs(
                            resultSet.getInt("id"),
                            resultSet.getString("email"),
                            resultSet.getString("action"),
                            resultSet.getString("description")

                    );

                    list.add(auditLogs);
                }
            }
        }

        return list;
    }




}