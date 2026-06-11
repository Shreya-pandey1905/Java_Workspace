package org.com.masstechBuisnessSolutions;

import java.util.ArrayList;
import java.util.List;

abstract class Payment {
    double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    abstract void processPayment();
}

class CreditCard extends Payment {

    long cardNumber;

    public CreditCard(long cardNumber, double amount) {
        super(amount);
        this.cardNumber = cardNumber;
    }

    @Override
    void processPayment() {
        System.out.println("Credit Card Process");
        System.out.println("Card Number is :" + cardNumber);
        System.out.println("Amount is " + amount);
        System.out.println("Payment Successful");


        double transaction_amount= 0.02 * amount;
        System.out.println("Transaction charge: " + transaction_amount);
        System.out.println("Original amount: " + amount);
        System.out.println("Final Amount Debited: " + transaction_amount+amount);


    }
}

class UPI extends Payment {

    String upi_id;

    public UPI(String upi_id, double amount) {
        super(amount);
        this.upi_id = upi_id;
    }

    @Override
    void processPayment() {
        System.out.println("UPI Process");
        System.out.println("Upi id is :" + upi_id);
        System.out.println("Amount is " + amount);
        System.out.println("Payment Successful");

        double transaction_amount= 0 * amount;
        System.out.println("Transaction charge: "  + transaction_amount);
        System.out.println("Original amount: " + amount);
        System.out.println("Final Amount Debited: " + (transaction_amount+amount));


    }
}

class NetBanking extends Payment {
    String bankname;

    public NetBanking(String bankname, double amount) {
        super(amount);
        this.bankname = bankname;
    }

    @Override
    void processPayment() {

        System.out.println("Netbanking Process");
        System.out.println("Bank name is :" + bankname);
        System.out.println("Amount is " + amount);
        System.out.println("Payment Successful");


        double transaction_amount= 0.01 * amount;
        System.out.println("Transaction charge: "+ transaction_amount);
        System.out.println("Original amount: " + amount);
        System.out.println("Final Amount Debited: " + (transaction_amount+amount));



    }
}

public class PaymentGatewaySystem {
    public static void main(String[] args) {
        CreditCard cc = new CreditCard(898888555,80000);

        UPI upi = new UPI("shreya555@upi",680000);
        NetBanking nb = new NetBanking("BOI",780000);

        List<Payment> list = new ArrayList<>();
        list.add(cc);
        list.add(upi);
        list.add(nb);

        System.out.println(list);
        cc.processPayment();
        upi.processPayment();
        nb.processPayment();
    }
}
