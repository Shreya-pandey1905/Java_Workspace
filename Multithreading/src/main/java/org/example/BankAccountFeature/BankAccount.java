package org.example.BankAccountFeature;

public class BankAccount {
    private double balance=1000;

    public  synchronized void withdraw(double amt) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());

        if (amt<balance) {
            Thread.sleep(1000);
            balance = balance - amt;//
            System.out.println("balance "+balance);
        }
        else {
            System.out.println("Insufficient");
        }
    }

}
