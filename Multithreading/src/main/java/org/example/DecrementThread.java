package org.example;

public class DecrementThread {

   public static volatile boolean flag= true;// volatile means take the value from main instead of cache

    static void main() throws InterruptedException {
        Thread worker = new Thread(

                ()->{
                    System.out.println("Worker Thread Started");
                    while (flag){

                    }
                  System.out.println("Worker Thread Stopped");
           }
        );
                worker.start();
                Thread.sleep(2000);
        System.out.println("Main thread stopped");
        flag=false;


    }
}
