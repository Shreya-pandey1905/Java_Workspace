package org.example;

public non-sealed class CreditCardPayment extends Payment{
    @Override
    public void pay() {
        System.out.println("Use Credit card for payment");
    }
}
