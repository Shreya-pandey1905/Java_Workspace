package org.example.ExecuterFramework;

import java.util.concurrent.*;

public class Main
{
    static void main() {
//        Executor executor = Executors.newSingleThreadExecutor();
//        ExecutorService executorss = Executors.newSingleThreadExecutor();
//        ScheduledExecutorService scheduledExecutorService= Executors.newScheduledThreadPool(1);
//        scheduledExecutorService.schedule(
//                () ->{
//                    System.out.println("Thread executing the class "+ Thread.currentThread().getName());
//        },3, TimeUnit.SECONDS);

       // Executor executor1 = Executors.newSingleThreadExecutor();
       // ExecutorService executor1 = Executors.newSingleThreadExecutor();
        ScheduledExecutorService scheduledExecutorService1= Executors.newScheduledThreadPool(1);
        scheduledExecutorService1.scheduleAtFixedRate(
                () ->{
                    System.out.println("Health check");
                },0,1, TimeUnit.SECONDS);
//
//        executor.execute(()->{
//            System.out.println( Thread.currentThread().getName());
//
//        });
    }
}
