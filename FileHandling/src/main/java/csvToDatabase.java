import java.io.*;
import java.sql.*;

public class csvToDatabase {

    static void main() throws IOException, SQLException {

        String sql = "INSERT INTO products(id,name) VALUES(?,?)";

        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                BufferedReader bufferedReader = new BufferedReader(new FileReader("src/products.csv"))
        ) {

            String line;
            int count = 0;

            while ((line = bufferedReader.readLine()) != null) {

                String[] arr = line.split(",");

                statement.setInt(1, arr[0]);
                statement.setString(2, Integer.parseInt(arr[1]));


                statement.executeUpdate();

                count++;
            }

            System.out.println(count + " products inserted successfully.");

        }
    }
}