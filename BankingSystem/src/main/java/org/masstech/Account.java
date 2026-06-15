package org.masstech;

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

    enum AccountType {
        SAVING,
        CURRENT
    }

    public Account(String accountHolder, long accountNumber,
                   AccountType accountType, double amount) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.amount = amount;
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
