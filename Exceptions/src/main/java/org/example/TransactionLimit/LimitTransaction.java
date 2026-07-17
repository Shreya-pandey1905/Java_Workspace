package org.example.TransactionLimit;

import java.io.File;
import java.util.Scanner;

public class LimitTransaction {
    static void main() {
        Scanner sc = new Scanner(System.in);

        int sum=0;
        int amount;
        int limit;
        String userInput;
        int lastAmount;
        do {
           limit=1000;
            System.out.println("Enter the amount to be transferred");
             amount=sc.nextInt();


        lastAmount=amount;
             sum= sum+amount;



            if (sum>=limit){
                throw new LimitExceeded("Limit exceeded with amount: "+lastAmount);
            }
            System.out.println("Want to proceed further");
            userInput=sc.next();

        }while (userInput.equalsIgnoreCase("yes"));



    }
}
