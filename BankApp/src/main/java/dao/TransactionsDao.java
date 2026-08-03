package dao;

import config.DBConnection;
import model.Status;
import model.Transactions;
import model.Type;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransactionsDao {

    public static Transactions create(Transactions transaction) throws SQLException {

        String sql = "insert into transactions(user_id,type,amount,balance_after,status,reason)values(?,?,?,?,?,?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

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

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, amount);
            statement.setInt(2, id);

            statement.executeUpdate();
            return true;
        }
    }

    public static boolean withdraw(double amount, int id) throws SQLException {
        final double limitamount = 50000;
        String sql2 = "select sum(amount) as sumamount from transactions where user_id = ? AND type = ? AND DATE(created_at) = ?";
        try(Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql2))
        {
            statement.setInt(1,id);
            statement.setString(2,Type.WITHDRAW.name());
            statement.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                double sumamount = resultSet.getDouble("sumamount");
                if (resultSet.wasNull()) {
                    sumamount = 0;
                }
                if (sumamount + amount <= limitamount){
                    String sql = "update users set balance = balance-? where id = ?";
                    try(PreparedStatement statement2 = connection.prepareStatement(sql))
                    {
                        statement2.setDouble(1,amount);
                        statement2.setInt(2,id);
                        return statement2.executeUpdate()==1;
                    }
                }else{
                    System.out.println("you have hit the daily limit of Rs 50000");
                    return false;
                }
            }
        }
        return false;
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

    public static List<Transactions> miniStatement(int id, String type) throws SQLException {

        List<Transactions> list = new ArrayList<>();

        String sql = "select * from transactions where user_id=? and type = ? order by id desc limit 3";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            statement.setString(2,type);

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
