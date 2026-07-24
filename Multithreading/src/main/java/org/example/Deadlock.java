package org.example;

public class Deadlock {
   public static Object lock1 = new Object();
    public static  Object lock2 = new Object();

    static void main() {
        Thread thread= new Thread(()->{
            synchronized (lock1){
                System.out.println("Thread 1 acquired lock1");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (lock2){
                    System.out.println("Thread 1 acquired lock2");

                }
            }
        });

        Thread thread2= new Thread(()->{
            synchronized (lock2){
                System.out.println("Thread 2 acquired lock1");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (lock1){
                    System.out.println("Thread 2 acquired lock2");

                }
            }
        });
        thread.start();
        thread2.start();
    }
}
