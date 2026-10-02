package dao;

import dto.EmpDto;
import dto.Employee;
import models.Manager;
import repo.IEmpService;
import util.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO implements IEmpService {

    private Connection cn;

    public EmpDAO() {
        try {
            cn = DbConnection.getConnetion();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addEmployee(EmpDto employee) {

        String sql = "INSERT INTO emps(ename, esalary, mid) VALUES (?, ?, ?)";

        try (PreparedStatement st = cn.prepareStatement(sql)) {

            System.out.println(employee.getName());

            st.setString(1, employee.getName());
            st.setDouble(2, employee.getSalary());
            st.setInt(3, employee.getmId());

            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Manager> getManager() {
        return getAllManagers();
    }

    public void connectionCheck() {
        System.out.println("Connection Success");
    }

    public List<Manager> getAllManagers() {

        String sql = "SELECT * FROM manager";

        List<Manager> managers = new ArrayList<>();

        try (
            Connection con = DbConnection.getConnetion();
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery()
        ) {

            while (rs.next()) {
                managers.add(
                    new Manager(
                        rs.getInt("mid"),
                        rs.getString("mname")
                    )
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return managers;
    }

    public List<Employee> getAllEmployee() {

        String sql = """
            SELECT
                e.eid,
                e.ename,
                e.esalary,
                m.mname
            FROM emps e
            LEFT JOIN manager m
                ON e.mid = m.mid
            """;

        List<Employee> list = new ArrayList<>();

        try (
            PreparedStatement st = cn.prepareStatement(sql);
            ResultSet rs = st.executeQuery()
        ) {

            while (rs.next()) {

                list.add(
                    new Employee(
                        rs.getInt("eid"),
                        rs.getString("ename"),
                        rs.getDouble("esalary"),
                        rs.getString("mname")
                    )
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}