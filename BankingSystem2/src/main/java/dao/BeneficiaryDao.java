package dao;

import config.DBConnection;
import model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BeneficiaryDao
{
    public static Beneficiary create(String name, long acc_no, String ifsc, String nickname,int user_id) throws SQLException {

        String sql = "insert into beneficiary(name,acc_no,ifsc,nickname,user_id)values(?,?,?,?,?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS)) {

         statement.setString(1,name);
         statement.setLong(2,acc_no);
         statement.setString(3,ifsc);
         statement.setString(4,nickname);
            statement.setInt(5, user_id);
            statement.executeUpdate();
            try (ResultSet keys = statement.getGeneratedKeys()){
                keys.next();
                Beneficiary beneficiary1 = findByID(keys.getInt(1));
                if (beneficiary1==null){
                    throw new SQLException("Not found beneficiary");
                }
                return beneficiary1;
            }
        }
    }

    public static Beneficiary findByID(int id) throws SQLException{
        String sql="select * from beneficiary where id=?";

        try(Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)
        ){
            statement.setLong(1,id);
            try(ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next()? map(resultSet): null;
            }
        }
    }
    public static Beneficiary updates(Beneficiary beneficiary) throws SQLException {

        String sql = "update beneficiary set name=?,acc_no=?,ifsc=?,nickname=? where id=?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1,beneficiary.name());
            statement.setLong(2,beneficiary.account_no());
            statement.setString(3,beneficiary.ifsc());
            statement.setString(4,beneficiary.nickname());
            statement.setInt(5,beneficiary.id());

            statement.executeUpdate();

            return beneficiary;
        }
    }

    public static void delete(int id) throws SQLException {
        String sql = "delete from beneficiary where id=?";
        try (Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1,id);
            statement.executeUpdate();
        }
    }

    public static List<Beneficiary> view(int id) throws SQLException {

        List<Beneficiary> list = new ArrayList<>();

        String sql = "select * from beneficiary where id=?";

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

    public static Beneficiary map(ResultSet resultSet) throws SQLException {

        return new Beneficiary(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getLong("acc_no"),
                resultSet.getString("ifsc"),
                resultSet.getString("nickname"),
                resultSet.getInt("user_id")
        );
    }






}
