package model;

import dao.TransactionsDao;

import java.sql.SQLException;

public class Users {
    public int getId() {
        return id;
    }

    private final int id;
    private final String name ;
    private final String email;
//    private final String password;

    private final long account_no;
    private final  String ifsc;
    private final String branch ;
    private final String role;
    private double balance;



    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public long getAccount_no() {
        return account_no;
    }

    public String getBranch() {
        return branch;
    }

    public String getIfsc() {
        return ifsc;
    }

    public String getRole() {
        return role;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance= balance;
    }



    public Users(int id, String name, String email, long account_no, String ifsc, String branch, String role, double balance) {
        this.id = id;
        this.name = name;
        this.email = email;

        this.account_no = account_no;
        this.ifsc = ifsc;
        this.branch = branch;
        this.role = role;
        this.balance = balance;
    }


}
