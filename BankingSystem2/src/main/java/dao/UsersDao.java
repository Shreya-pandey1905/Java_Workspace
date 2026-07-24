package dao;

import config.DBConnection;
import model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDao {

public static Users create(String name, String email, String password,
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
            Users customer = findByID(keys.getLong(1));
            if (customer==null){
                throw new SQLException("Not found user");
            }
            return customer;
        }
    }
}

    public static Users findByID(long id) throws SQLException{
        String sql="select * from users where id=?";

        try(Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)
        ){
            statement.setLong(1,id);
            try(ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next()? map(resultSet): null;
            }
        }
    }

    public  static  Users map(ResultSet resultSet) throws SQLException {
    return new Users(resultSet.getInt("id"),
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

    public static Users findbyEmailAndPassword(String email, String pass) throws SQLException {
        String sql="select * from users where email=? and password=?";

        try(Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)
        ){
            statement.setString(1,email);
            statement.setString(2,pass);
            try(ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next()? map(resultSet): null;
            }
        }

    }

    public static double getBalance(int id) throws SQLException {

        String sql = "select balance from users where id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("balance");
                }
                return 0;
            }
        }
    }

    public static Users findByAccountNo(long accountNo) throws SQLException {
        String sql = "select * from users where  account_no = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, accountNo);

            try (ResultSet rs = statement.executeQuery()) {
                return rs.next() ? map(rs) : null;
            }
        }
    }


    public static void lockUser(int id) throws SQLException {
        String sql = "update users set user_lock=true where id=? ";
        try (Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    //UPDATE users
    //SET failed_attempts = failed_attempts + 1
    //WHERE id = ?;

    public static void incrAttempts(int id, int attempts) throws SQLException {
        String sql = "update users set attempts=attempts+1 where id=? ";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, attempts);

            statement.setInt(2, id);
            statement.executeUpdate();
        }
    }


    public static void resetAttempts(int id, int attempts) throws SQLException {
        String sql = "update users set attempts=0 where id=? ";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    public static boolean changePassword(String newPass, int id) throws SQLException {
    String sql = "update users set password=? where id=?";
    try (Connection connection = DBConnection.getConnection();
    PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setString(1, newPass);
        statement.setInt(2, id);
        return statement.executeUpdate()==1;
    }
    }

    public static boolean verifyPassword(int id,String password) throws SQLException
    {
        String sql = "select password from users where id = ?";
        try(Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql))
        {
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                String pwd = resultSet.getString("password");
                return pwd.equals(password);
            }
            return false;
        }
    }

}



