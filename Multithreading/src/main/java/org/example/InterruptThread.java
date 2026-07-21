package org.example;

public class InterruptThread extends Thread{

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("I got interrupted :(");
            throw new RuntimeException(e);
        }
    }
}
