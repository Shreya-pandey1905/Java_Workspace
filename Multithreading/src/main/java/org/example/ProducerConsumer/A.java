package org.example.ProducerConsumer;

public class A {

    boolean flag = true;
    int count=0;

    public  synchronized void produce() throws InterruptedException {
        while (count<=50){
            if (flag==true){
                count+=1;
                System.out.println("producer produced item "+count);
                flag=false;
                notify();
                wait();
            }else {
                wait();
            }
        }

    }

    public synchronized void consume () throws InterruptedException {
        while (count<=51){
            if (flag== true){
                wait();
            }
            else {

                System.out.println("Consumer item consumed: "+count);
                flag= true;
                notify();
                wait();

            }
        }
    }



}
