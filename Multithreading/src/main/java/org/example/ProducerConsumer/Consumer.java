package org.example.ProducerConsumer;

public class Consumer extends Thread {

    A a ;
    public Consumer(A a){
        this.a= a;

    }

    @Override
    public void run() {
        try {
            a.consume();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
