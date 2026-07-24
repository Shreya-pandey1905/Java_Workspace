package org.example;

import java.nio.file.LinkOption;

public class StarvationDemo {

    public static final Object lock = new Object();

    static void main() {
        Thread highPriority= new Thread(
                ()->{
         while (true){
             synchronized (lock){
                 System.out.println("High Priority");
             }
         }

        }
        );

           Thread lowPriority = new Thread( ()->{
            while (true){
                synchronized (lock){
                    System.out.println("High Priory");
                }
            }

        }
           );

              highPriority.setPriority(Thread.MAX_PRIORITY );
        lowPriority.setPriority(Thread.MIN_PRIORITY);
        highPriority.start();
        lowPriority.start();

    }
}
