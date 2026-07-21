package org.example.UsingLambda;

public class ChildThread extends Thread {
    static  int  sum =0;
    static void main() throws InterruptedException {
        Runnable r = ()->{
            System.out.println( Thread.currentThread().getName());
            // this will return child therad which is Thread 0
            for(int i =0;i<=10;i++){
                sum = sum +i;
            }
        };


        Thread t1=new Thread(r);
        Thread t2 = new Thread(r);
        System.out.println("runnable before start "+ t1.getState());

        t1.start();


        System.out.println("runnable thread name:  "+t1.getName());
        System.out.println("Runnable after start "+t1.getState());



        t1.join();//main-->waiting
        System.out.println(t1.getState());

//        System.out.println( Thread.currentThread().getName());  -- will give current thread, from 13 all s happening in main thread
//        System.out.println(t2.getName());
//        System.out.println(t1.getState());
    }
}
