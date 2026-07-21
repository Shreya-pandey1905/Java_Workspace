package org.example.UsingImplements;

public class MainThread
{
    static void main() throws InterruptedException {
        ChildThread ct = new ChildThread();
        Thread t = new Thread(ct);
        t.start();
        Thread.sleep(1000);
        t.join();// wait for thread to finish the program
        System.out.println(ChildThread.sum);
    }
}
