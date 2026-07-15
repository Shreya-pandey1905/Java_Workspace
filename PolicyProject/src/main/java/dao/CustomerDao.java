package dao;



import config.DBConnection;
import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDao {

    public void addCustomer(Customer customer) throws Exception {

        String sql =
                "insert into customer(customer_id, customer_name, phone_no) values(?,?,?)";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setString(1, customer.getCustomerID());
            ps.setString(2, customer.getCustomerName());
            ps.setString(3, customer.getPhoneNo());

            ps.executeUpdate();
        }
    }

    public Customer findCustomerById(String id) throws Exception {

        String sql =
                "select * from customer where customer_id=?";

        try(Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql))
        {
            ps.setString(1,id);

            ResultSet rs = ps.executeQuery();

            if(rs.next())
            {
                return new Customer(
                        rs.getString("customer_id"),
                        rs.getString("customer_name"),
                        rs.getString("phone_no")
                );
            }
        }

        return null;
    }
}