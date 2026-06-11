package org.com.masstechBuisnessSolutions;

import java.util.Scanner;

public class NumberAnalyzer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");

        float number = sc.nextFloat();

        if (number > 0) {
            System.out.println("Number is Positive");
            if (number % 2 == 0) {
                System.out.println("Number is even");
            } else {
                System.out.println("Number is odd");
            }
        } else if (number < 0) {
            System.out.println("Number is negative");
        } else {
            System.out.println("Number is Zero");
        }


    }


}

