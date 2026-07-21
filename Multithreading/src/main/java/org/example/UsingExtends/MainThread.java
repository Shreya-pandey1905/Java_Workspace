package org.example.UsingExtends;

public class MainThread
{
    static void main() {
        ChildThread ct = new ChildThread();
        ct.start();
        // Thread Started
        System.out.println(ChildThread.sum);
    }
}
