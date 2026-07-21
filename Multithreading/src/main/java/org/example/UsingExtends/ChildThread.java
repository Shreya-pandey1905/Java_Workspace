package org.example.UsingExtends;

public class ChildThread extends Thread{
    static int  sum=0;
    public void run(){
        for (int i=0;i<=3;i++){
           sum= sum+i;

        }
        System.out.println(sum);
    }
}
