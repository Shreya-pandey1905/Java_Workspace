package org.example.BankAccountFeature;

public class ATM {
    static void main(){
        BankAccount bankAccount = new BankAccount();
        Thread thread = new Thread(()->{

            try {
                bankAccount.withdraw(700);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"ATM");


        Thread thread1 = new Thread(()->{

            try {
                bankAccount.withdraw(700);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"NetBanking");

        thread.start();
        thread1.start();
     //   System.out.println(thread.getName());

     //   System.out.println(thread1.getName());



    }
}
