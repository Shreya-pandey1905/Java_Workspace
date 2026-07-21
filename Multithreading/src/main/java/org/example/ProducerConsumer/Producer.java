package org.example.ProducerConsumer;

public class Producer extends Thread {
    A a;
    public Producer(A a){
        this.a= a;
    }

    @Override
    public void run() {
        try {
            a.produce();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
