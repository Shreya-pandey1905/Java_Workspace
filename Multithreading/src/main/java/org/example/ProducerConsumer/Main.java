package org.example.ProducerConsumer;

public class Main {
    static void main() {
        A a = new A();
        Producer producer= new Producer(a);

        Consumer consumer = new Consumer(a);

        producer.start();
        consumer.start();

    }
}
