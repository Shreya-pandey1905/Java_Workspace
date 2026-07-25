import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public static void createUser(String name, String username, String hashedPass){
        String sql= "insert into users (name, username,password) values (?,?,?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1,name);
            statement.setString(2,username);
            statement.setString(3,hashedPass);
            if (statement.executeUpdate()==1){
                System.out.println("User added");
            }else {
                System.out.println("Errorrrr");
            };

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


    public static String findbyNameAndPassword(String uname, String pwd) throws SQLException, ClassNotFoundException {
        String sql = "select * from users where username=? and password=?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setString(1, uname);
            statement.setString(2, pwd);


            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("name");
                } else {
                    System.out.println("Not found");
                }
            }
        }
        return null;
    }


    }

