package org.example.PaymentThreads;


public class MainThread {

    static void main() throws InterruptedException {
        ChildThread ct = new ChildThread();
        Thread t1 = new Thread(ct);
        t1.start();
        t1.join();
        System.out.println("Generate invoice");

    }
}
