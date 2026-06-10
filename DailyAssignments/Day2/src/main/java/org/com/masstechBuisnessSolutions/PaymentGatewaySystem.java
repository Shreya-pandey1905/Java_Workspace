package org.com.masstechBuisnessSolutions;

abstract class Payment{
    double amount;
    public Payment (double amount){
        this.amount=amount;
    }
    abstract void processPayment();
}
class CreditCard extends Payment{
    public CreditCard(double cardNumber, double amount){
        super(amount);
    }

    @Override
    void processPayment() {

    }
}
class UPI extends Payment{
    
    @Override
    void processPayment() {

    }
}
class NetBanking extends Payment{
    @Override
    void processPayment() {

    }
}

public class PaymentGatewaySystem {
}
