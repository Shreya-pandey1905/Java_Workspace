package org.com.masstechBuisnessSolutions;

import java.util.Scanner;

public class AtmPinChecker {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int atmPin = 1234;
        int attempts = 3;

        for (int i = 1; i <= attempts; i++) {

            System.out.print("Enter thr ATM Pin : ");
            int userPin = sc.nextInt();

            if (userPin == atmPin) {
                System.out.println("Login successful");
                System.out.println("Welcome to ATM Services");
                break;
            } else {
                int remainingAttempts = attempts - i;

                if (remainingAttempts > 0) {
                    System.out.println("Invalid PIN. Attempts Remaining: "
                            + remainingAttempts);
                } else {
                    System.out.println("Invalid PIN");
                    System.out.println("Card Blocked. Please contact the bank.");
                }
            }
        }


    }
}