package org.com.masstechBuisnessSolutions;

import java.util.Scanner;

public class AtmSimulation {
    public static void main(String[] args) {

        double accountBalance = 50000;
        Scanner sc = new Scanner(System.in);
        int userInput;
        String lastTransactionDetails = "No transaction yet";

        do {
            System.out.println("Choose from the menu");
            System.out.println("Enter 1 for choose balance");
            System.out.println("Enter 2 for Deposit Money");
            System.out.println("Enter 3 for Withdraw Money");
            System.out.println("Enter 4 for Mini Statement ");
            System.out.println("Enter 5 for Exit ");
            userInput = sc.nextInt();

            switch (userInput) {
                case 1: {
                    System.out.println("Current Account balance is : " + accountBalance);
                    break;
                }
                case 2: {
                    System.out.println("Enter the amount to be deposited");
                    double depositAmount = sc.nextDouble();
                    System.out.println("Amount deposited successfully");
                    accountBalance += depositAmount;
                    System.out.println("Your updated balance is : " + (accountBalance));
                    lastTransactionDetails = "Deposited amount: " + depositAmount;

                    break;
                }

                case 3: {
                    System.out.println("Enter the amount to be withdrawn");
                    double withdrawAmount = sc.nextDouble();
                    if (withdrawAmount <= accountBalance) {
                        System.out.println("Amount withdrawn.");
                        accountBalance -= withdrawAmount;
                        System.out.println("Your remaining amount is: " + (accountBalance));
                    } else {
                        System.out.println("Not Sufficient amount");
                    }
                    lastTransactionDetails = "Withdrawn amount: " + withdrawAmount;
                    break;
                }
                case 4: {
                    System.out.println("Mini Statement");
                    System.out.println(lastTransactionDetails);
                    break;
                }
                case 5: {

                    System.out.println("Thank you! Have a normal day");
                    break;

                }
                default: {
                    System.out.println("Invalid Option");
                }


            }

        } while (userInput != 5);

    }
}
