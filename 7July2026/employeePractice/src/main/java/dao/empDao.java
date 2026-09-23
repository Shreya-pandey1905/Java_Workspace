package dao;

import model.emp;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class empDao {

    DBConnection dbcon = new DBConnection();

    public void addEmp(emp emp) {

        String sql = "insert into Employee(eid, ename, esal, mid) values(?,?,?,?)";

        try(Connection connection = dbcon.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setInt(1, emp.getEid());
            statement.setString(2, emp.getEname());
            statement.setDouble(3, emp.getEsal());
            statement.setInt(4, emp.getMid());

            statement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public List<emp> getAllEmp() {

        List<emp> employees = new ArrayList<>();
        String sql = "select * from Employee";
        try (PreparedStatement statement = dbcon.getConnection().prepareStatement(sql)) {

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                emp e = new emp(resultSet.getInt("eid"),
                        resultSet.getString("ename"),
                        resultSet.getDouble("esal"),
                        resultSet.getInt("mid")
                );
                employees.add(e);

            }
            return  employees;

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }
}



