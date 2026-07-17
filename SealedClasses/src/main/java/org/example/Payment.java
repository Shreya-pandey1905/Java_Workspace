package org.example;

public sealed class Payment permits CreditCardPayment, DebitCardPayment,UPIPayment,NetBankingPayment {
    public void pay(){
        System.out.println("Payment done");
    }

}
