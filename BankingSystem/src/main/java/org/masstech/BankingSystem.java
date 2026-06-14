package org.masstech;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

class Services {
    List<Account> list = new ArrayList<>();

    public void addAccount() {

        double minBalanceOfSavingAccount=1000;
        double minBalanceOfCurrentAccount=0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the name of the account holder");
        String accountHolder = sc.next();

        System.out.println("Enter the account number");
        long accountNumber = sc.nextLong();

        System.out.println("Enter the account type either SAVING or CURRENT");
        Account.AccountType accountType =
                Account.AccountType.valueOf(sc.next().toUpperCase());

        System.out.println("Enter the amount");
        double amount = sc.nextDouble();

        if(accountType == Account.AccountType.SAVING && amount < minBalanceOfSavingAccount){
            System.out.println("saving account requires minimum balance of Rs 1000");
                 return;
        }


        Account ac = new Account(accountHolder, accountNumber, accountType, amount);
        list.add(ac);
    }

    public void displayAllAccounts() {
        for (Account al : list) {
            System.out.println(al);
        }
    }



    public void generateMonthlyStatements() {
        List<Account> list = new ArrayList<>();

        if(list.isEmpty()){
            System.out.println("No accounts found.");
            return;
        }


        for(Account account : list){

            double interestRate;

            if(account.getAccountType() == Account.AccountType.SAVING){
                interestRate = 6;
            } else {
                interestRate = 2;
            }

            double interest =
                    account.getAmount() * interestRate / 100 / 12;

            double closingBalance =
                    account.getAmount() + interest;


        }
    }
}



public class BankingSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Services services = new Services();

        double minBalance= 0;

        int userInput;

        do {
            System.out.println("Press 1 for creating account");
            System.out.println("Press 2 for deposit amount");
            System.out.println("Press 3 for Viewing details");
            System.out.println("Press 4 for withdraw details");
            System.out.println("Press 5 for transfer amount");
            System.out.println("Press 6 for monthly statements");

            System.out.println("Press 7 for Exit");

            userInput = sc.nextInt();

            switch (userInput) {

                case 1: {

                    services.addAccount();

                    System.out.println("Account created successfully.");
                    break;
                }

                case 2: {
                    System.out.println("Enter the account number");
                    long accountNumber = sc.nextLong();

                    Account account = null;

                    for (Account ac : services.list) {
                        if (ac.getAccountNumber() == accountNumber) {
                            account = ac;
                            break;
                        }
                    }

                    if (account == null) {
                        System.out.println("Account not found");
                        break;
                    }

                    System.out.println("Enter amount to deposit");
                    double amountDeposit = sc.nextDouble();

                    account.setAmount(account.getAmount() + amountDeposit);

                    System.out.println("Available balance: " + account.getAmount());
                    break;
                }

         case 3: {
                    services.displayAllAccounts();
                    break;
                }

                case 4: {
                    System.out.println("Enter the account number");
                    long accountNumber = sc.nextLong();



                    Account account = null;

                    for (Account ac : services.list) {
                        if (ac.getAccountNumber() == accountNumber) {
                            account = ac;
                            break;
                        }
                    }

                    if (account == null) {
                        System.out.println("Account not found");
                        break;
                    }


                    System.out.println("Enter amount to withdraw");
                    double amountWithdrawn = sc.nextDouble();



                    if(account.getAccountType() == Account.AccountType.SAVING){
                        minBalance = 1000;

                        if(account.getAmount() >= amountWithdrawn && account.getAmount() >= minBalance ){

                            account.setAmount(account.getAmount() - amountWithdrawn);
                            System.out.println("Your available balance is :  " + account.getAmount());

                        }
                        else{
                            System.out.println("You need to keep minimum balance of Rs 1000 in your saving account");
                        }
                    } else if (account.getAccountType() == Account.AccountType.CURRENT) {
                        if (account.getAmount() >= amountWithdrawn){
                            account.setAmount(account.getAmount() - amountWithdrawn);
                            System.out.println("Your available balancd is : " + account.getAmount());
                        }
                    }


//                    if (account.getAmount() >= amountWithdrawn) {
//                        account.setAmount(account.getAmount() - amountWithdrawn);
//                        System.out.println("Available balance: " + account.getAmount());
//                    } else {
//                        System.out.println("Not a sufficient balance");
//                    }

                    break;
                }

                case 5: {
                    System.out.println("Enter the account number");
                    long accountNumber = sc.nextLong();

                    minBalance = 1000;
                    Account account = null;

                    for (Account ac : services.list) {
                        if (ac.getAccountNumber() == accountNumber) {
                            account = ac;
                            break;
                        }
                    }

                    if (account == null) {
                        System.out.println("Account not found");
                        break;
                    }

                    System.out.println("Enter the amount to be transferred");
                    double transferAmount = sc.nextDouble();

                    if(account.getAccountType() == Account.AccountType.SAVING){
                        minBalance = 1000;
                    }

                    if(account.getAmount() - transferAmount >= minBalance){
                        account.setAmount(account.getAmount() - transferAmount);
                        System.out.println("Available balance: " + account.getAmount());
                    }
                    else{
                        System.out.println("Insufficient balance");
                    }

                    break;
                }

                case 6: {
                    System.out.println("Thank you for using our application");
                    break;
                }

                default: {
                    System.out.println("Invalid choice");
                }
            }

        } while (userInput != 6);
    }
}