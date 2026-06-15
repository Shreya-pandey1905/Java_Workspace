package org.masstech;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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

                    System.out.println("Enter account number");
                    long accountNumber = sc.nextLong();

                    System.out.println("Enter amount to deposit");
                    double amountTodeposit = sc.nextDouble();

                    services.depositAmountService(accountNumber, amountTodeposit);

                    break;
                }
                case 3: {
                    services.displayAllAccounts();
                    break;
                }

                case 4: {

                    System.out.println("Enter the account number");
                    long accountNumber = sc.nextLong();

                    System.out.println("Enter amount to withdraw");
                    double withdrawAmount = sc.nextDouble();
                    services.withdrawAmountService(accountNumber, withdrawAmount);

//                    try{
//
//                        services.withdrawAmountService(accountNumber, withdrawAmount);
//                    }
//                    catch(DormantAccException e)
//                    {
//                        System.out.println(e.getMessage());
//                    }
                    break;
                }

                case 5: {
                    System.out.println("Enter the account number");
                    long accountNumber = sc.nextLong();

                    System.out.println("Enter amount to transfre");
                    double transferAmount = sc.nextDouble();

                    services.transferAmountService(accountNumber, transferAmount);

//                    try
//                    {
//                        services.transferAmountService(accountNumber, transferAmount);
//                    }
//                    catch(DormantAccException e)
//                    {
//                        System.out.println(e.getMessage());
//                    }


                    break;
                }

                case 6:
                {

                    System.out.println("Enter account number");
                    long accountNumber = sc.nextLong();

                    services.generateMonthlyStatements(accountNumber);
                }


                case 7:{
                    System.out.println("Thank you for using our application");
                    break;
                }
                default: {
                    System.out.println("Invalid choice");
                }
            }

        } while (userInput != 7);
    }
}