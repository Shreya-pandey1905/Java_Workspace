package dao;

import config.DBConnection;
import model.Transactions;
import model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static dao.UsersDao.findByID;

public class TransactionsDao {
    public static Users deposit(double amount, int id) throws SQLException {

        String sql = "update users set balance = balance + ? where id=?";

        try(Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setDouble(1, amount);
            statement.setInt(2, id);

            int rows = statement.executeUpdate();

            if(rows == 0){
                return null;
            }

            return findByID(id);
        }
    }


    public static Transactions create(String name, String email, String password,
                                      long account_no, String ifsc, String branch)
            throws SQLException {
        String sql = "insert into users (name,email ,password,account_no,ifsc,branch) values(?,?,?,?,?,?)";
        try(Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection .prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS)
        )

        {
            statement.setString(1,name);
            statement.setString(2,email);
            statement.setString(3,password);
            statement.setLong(4,account_no);
            statement.setString(5,ifsc);
            statement.setString(6, branch);



            statement.executeUpdate();
            try (ResultSet keys = statement.getGeneratedKeys()){
                keys.next();
                Transactions transactions = findByID(keys.getLong(1));
                if (transactions==null){
                    throw new SQLException("Not found user");
                }
                return transactions;
            }
        }
    }
}
