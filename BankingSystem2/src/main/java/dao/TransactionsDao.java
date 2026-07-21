package dao;

import config.DBConnection;
import model.Status;
import model.Transactions;
import model.Type;
import model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static dao.UsersDao.findByID;

public class TransactionsDao {

    public static Transactions create(Transactions transaction) throws SQLException {

        String sql = " INSERT INTO transactions(user_id,type,amount,balance_after,status,reason)VALUES(?,?,?,?,?,?)";

        try(Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql))
        {

            statement.setInt(1, transaction.getUser_id());
            statement.setString(2, transaction.getType().name());
            statement.setDouble(3, transaction.getAmount());
            statement.setDouble(4, transaction.getBalance_after());
            statement.setString(5, transaction.getStatus().name());
            statement.setString(6, transaction.getReason());

            statement.executeUpdate();

            return transaction;
        }
    }

    public static boolean deposit(double amount, int id) throws SQLException {

        String sql = "update users set balance = balance + ? where id=?";

        try(Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setDouble(1, amount);
            statement.setInt(2, id);

            int rows = statement.executeUpdate();



            return true;
        }
    }

    public static Users withdraw(double amount, int id) throws SQLException {

        Users user = findByID(id);

        if (user.getBalance() < amount) {
            return null;
        }

        String sql = "update users set balance = balance - ? where id=?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setDouble(1, amount);
            statement.setInt(2, id);

            statement.executeUpdate();

            return findByID(id);
        }
    }

    public static List<Transactions> transactionHistory(int id) throws SQLException {

        List<Transactions> list = new ArrayList<>();

        String sql = "select * from transactions where user_id=?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    list.add(map(resultSet));
                }
            }
        }

        return list;
    }

    public static Transactions map(ResultSet resultSet) throws SQLException {

        return new Transactions(
                resultSet.getInt("user_id"),
                Type.valueOf(resultSet.getString("type")),
                resultSet.getDouble("amount"),
                resultSet.getDouble("balance_after"),
                Status.valueOf(resultSet.getString("status")),
                resultSet.getString("reason")
        );
    }

}
