package org.example.ExecuterFramework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuterCachess {
    static void main() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=1;i<=10;i++)
        {
            int orderId=i;
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName()+" processing order : "+orderId);
            });
        }
        executorService.shutdown();
    }
}

