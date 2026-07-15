package model;

public class Customer {

    private final String customerID;
    private String customerName;
    private String phoneNo;

    public Customer(String customerID, String customerName, String phoneNo) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.phoneNo = phoneNo;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}