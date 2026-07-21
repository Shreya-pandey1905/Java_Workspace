package org.example;

public class MainThread {
    static void main() {
        InterruptThread i = new InterruptThread();
        i.start();
        i.interrupt();
    }
}

