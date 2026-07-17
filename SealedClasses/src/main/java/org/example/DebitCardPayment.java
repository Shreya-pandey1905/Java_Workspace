package org.example;

public non-sealed class DebitCardPayment extends Payment{

    @Override
    public void pay() {
        System.out.println("Use debit card for payment");

    }
}
