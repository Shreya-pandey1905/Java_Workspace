package org.example;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegers {
//    public static volatile int count=0;
 static AtomicInteger count=new AtomicInteger();


    static void main() throws InterruptedException {
            Runnable runnable =()->{
            for (int i=1;i<=10000;i++){
//                count++;
                count.incrementAndGet();
            }
        };
        Thread thread=new Thread(runnable);
        Thread thread2= new Thread(runnable);
        thread.start();
        thread2.start();
        thread.join();
        thread2.join();
        System.out.println(count);
    }

}

