package org.example.InsufficientBalance;

public class Accounts {

    int balance ;
    public Accounts(int balance){
        this.balance=balance;

    }

    static void main() {

       Accounts accounts = new Accounts(10000);
        if (accounts.balance<70000) {
            throw new InsufficientBalance("Insuffient balance with amount "+accounts.balance );

        }
    }


}
