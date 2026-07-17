package org.example.Matrimony;

import java.util.Scanner;

public class MatrimonyException {

    static void main() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to matrimony.com");
        System.out.println("Enter your age: ");
        int age =sc.nextInt();

        if (age>70){
            throw new TooOldForMarriage("Too old for marriage");
        }  else if (age<18){
            throw new TooYoungForMarriage("Too young for marriage");
        }
        else {
            System.out.println("Your are eligible for marriage");
        }


    }
}
