
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DBConnection {

        private static final String jdbc_url = "jdbc:mysql://localhost:3307/servlets?allowPublicKeyRetrieval=true";
    private static final String user = "root";
    private static final String pwd = "";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection(jdbc_url, user, pwd);


        return conn;

    }

}


