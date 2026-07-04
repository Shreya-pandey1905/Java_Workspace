package model;


public class Customer{

    final  private  int customerID;

    public int getCustomerID() {
        return customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }

    private String customerName;
    private long phoneNo;

    public Customer(int customerID,String customerName,long phoneNo){
        this.customerID= customerID;
        this.customerName= customerName;
        this.phoneNo= phoneNo;
    }
}