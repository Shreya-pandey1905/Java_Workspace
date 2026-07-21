package org.example.PaymentThreads;

public class ChildThread extends Thread{
    @Override
    public void run() {
        System.out.println("Payment Started");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Payment Completed");
    }
}
