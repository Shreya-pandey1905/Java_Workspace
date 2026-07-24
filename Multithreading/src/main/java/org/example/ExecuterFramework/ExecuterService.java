package org.example.ExecuterFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ExecuterService {
    static void main() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);


        for(int i=1;i<=100;i++)
        {
            int orderId=i;
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName()+" processing order : "+orderId);
            });
        }
    }
}
