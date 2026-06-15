package org.masstech;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Services {
    List<Account> list = new ArrayList<>();
    List<String> transactions = new ArrayList<>();

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

    public Account verifyAccount(long accountNumber) {

        for (Account account : list) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }

        return null;
    }

    public void depositAmountService(long accountNumber , double depositAmount ) {
        Account ac = verifyAccount(accountNumber);

//        if(ac.getStatus().equals("DORMANT"))
//        {
//            ac.setStatus("NORMAL");
//        }

        ac.setAmount(depositAmount+ ac.getAmount());

        transactions.add("Account number: " + accountNumber  +"Deposited amount: " + depositAmount);
        if(ac.getStatus().equals("DORMANT"))
        {
            ac.setStatus("NORMAL");
        }



        System.out.println("Your amount deposited successfully ");
        System.out.println("Your remaining balance is:  "+ ac.getAmount());


    }

    public void withdrawAmountService(long accountNumber, double amountWithdrawn)
//            throws DormantAccException
    {
        Account account = verifyAccount(accountNumber);

//Dormant logic


//        if(account.getStatus().equals("DORMANT"))
//        {
//            throw new DormantAccException(
//                    "Account is dormant you can only deposit");
//        }

         if (account.getAccountType() == Account.AccountType.SAVING) {

            double minBalance = 1000;  // fir saving acc

            if (account.getAmount() - amountWithdrawn >= minBalance) {

                account.setAmount(account.getAmount() - amountWithdrawn);

                transactions.add("Account number: " + accountNumber +"Account Type: "+ Account.AccountType.SAVING +"Withdrawn  amount: " + amountWithdrawn);

                System.out.println("amount successfully withdrawn");
                System.out.println("Your available balance is : " + account.getAmount());

            } else {

                System.out.println(
                        "You need to keep minimum balance of Rs 1000 in your saving account");
            }

        } else {

                 //fort current account

            if (account.getAmount() >= amountWithdrawn) {

                account.setAmount(account.getAmount() - amountWithdrawn);

                transactions.add("Account number: " + accountNumber +"Account Type: "+ Account.AccountType.CURRENT +"Withdrawn  amount: " + amountWithdrawn);


                System.out.println("amount successfully withdrawn");
                System.out.println("Your available balance is : " + account.getAmount());

            } else {

                System.out.println("Not sufficient balance");
            }
        }
    }

    public void transferAmountService(long accountNumber, double amountTransferred)
//            throws DormantAccException
    {

        Account account = verifyAccount(accountNumber);


//        if(account.getStatus().equals("DORMANT"))
//        {
//            throw new DormantAccException(
//                    "Account is dormant you can only deposit");
//        }

        if (account.getAccountType() == Account.AccountType.SAVING) {

            double minBalance = 1000;  // fir saving acc

            if (account.getAmount() - amountTransferred >= minBalance) {

                account.setAmount(account.getAmount() - amountTransferred);
                transactions.add("Account number: " + accountNumber +"Account Type: "+ Account.AccountType.SAVING +"Transferred  amount: " + amountTransferred);


                System.out.println("amount successfully withdrawn");
                System.out.println("Your available balance is : " + account.getAmount());

            } else {

                System.out.println(
                        "You need to keep minimum balance of Rs 1000 in your saving account");
            }

        } else {

            //fort current account

            if (account.getAmount() >= amountTransferred) {

                account.setAmount(account.getAmount() - amountTransferred);

                transactions.add("Account number: " + accountNumber +"Account Type: "+ Account.AccountType.CURRENT +"Withdrawn  amount: " + amountTransferred);


                System.out.println("amount successfully withdrawn");
                System.out.println("Your available balance is : " + account.getAmount());

            } else {

                System.out.println("Not sufficient balance");
            }
        }

    }

    public void generateMonthlyStatements(long accountNumber) {
        Account account = verifyAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found");
            return;
        }

        System.out.println("Here's your monthly statement:");

        if (transactions.isEmpty()) {
            System.out.println("No transactions found");
            return;
        }

        for (String transaction : transactions) {
            if (transaction.contains(String.valueOf(accountNumber))) {
                System.out.println(transaction);
            }
        }

        double interestRate;

        if (account.getAccountType() == Account.AccountType.SAVING) {
            interestRate = 6;
        } else {
            interestRate = 2;
        }

        double interest = account.getAmount() * interestRate / 100;

        System.out.println("Account Number: " + account.getAccountNumber() + " Account Type: " + account.getAccountType() + " Interest amount: " + interest);

    }

    }