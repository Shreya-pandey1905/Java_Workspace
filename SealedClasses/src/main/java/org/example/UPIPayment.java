package org.example;

public non-sealed class UPIPayment extends Payment {
    @Override
    public void pay() {
        System.out.println("Use UPI for payment");

    }
}
