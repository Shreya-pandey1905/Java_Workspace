package org.example.UsingImplements;

public class ChildThread implements Runnable{
 static int sum=0;
    @Override
    public void run() {
        for (int i=0;i<=3;i++){
            sum= sum+i;

        }
    }
}
