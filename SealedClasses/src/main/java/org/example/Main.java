package org.example;

public class Main {
    static void main() {
        CreditCardPayment creditCardPayment= new CreditCardPayment();
        DebitCardPayment debitCardPayment= new DebitCardPayment();
        NetBankingPayment netBankingPayment = new NetBankingPayment();
        UPIPayment upiPayment = new UPIPayment();

        creditCardPayment.pay();
        debitCardPayment.pay();
        netBankingPayment.pay();
        upiPayment.pay();
    }
}
