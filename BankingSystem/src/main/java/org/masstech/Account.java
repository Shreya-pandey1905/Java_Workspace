package org.masstech;

import java.time.LocalDate;

class Account {

    @Override
    public String toString() {
        return "Account{" +
                "accountHolder='" + accountHolder + '\'' +
                ", accountNumber=" + accountNumber +
                ", accountType=" + accountType +
                ", amount=" + amount +
                '}';
    }

    private String accountHolder;
    private long accountNumber;
    private AccountType accountType;
    private double amount;

    private String status;

    enum AccountType {
        SAVING,
        CURRENT
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Account(String accountHolder, long accountNumber, AccountType accountType, double amount) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.amount = amount;

        this.status = "NORMAL";
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {

        this.amount = amount;
    }
}
