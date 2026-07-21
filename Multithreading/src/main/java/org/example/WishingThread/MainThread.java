package org.example.WishingThread;



public class MainThread {

    static void main() {

        Display d1 = new Display();
        ChildThread childThread1 = new ChildThread(d1,"jake");
        ChildThread childThread2 = new ChildThread(d1, "ankush");

        childThread1.start();
        childThread2.start();
    }
}
