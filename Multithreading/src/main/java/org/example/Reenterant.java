package org.example;


import java.util.concurrent.locks.ReentrantLock;

public class Reenterant {
    static ReentrantLock reenterant=new ReentrantLock();

    public static void test1(){
        reenterant.lock();

        try {
            System.out.println(reenterant.getHoldCount());

        }finally {
            reenterant.unlock();
        }
    }

    static void main() {
        reenterant.lock();

        try {
            System.out.println(reenterant.getHoldCount());
            test1();
        }finally {
            reenterant.unlock();
        }


    }
}
