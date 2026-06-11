package org.com.masstechBuisnessSolutions;

import java.util.Scanner;

public class AtmPinChecker {
    public static void main(String[] args) {
        System.out.println("Enter your atm pin");
        Scanner sc = new Scanner(System.in);
        long user_pin = sc.nextLong();

        long atm_pin = 7899;
        int attempts = 3;

        for (int i = 1; i <= attempts; i++) {
            if (user_pin != atm_pin) {
                System.out.println("Invalid Pin");
                break;
            } else {
                System.out.println("Login Successful");
            }
            atm_pin -= 1;
        }
    }
}
