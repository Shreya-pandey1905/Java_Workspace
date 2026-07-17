package org.example;

public non-sealed class NetBankingPayment extends Payment{
    @Override
    public void pay() {
        System.out.println("Use netbanking for payment");

    }
}
