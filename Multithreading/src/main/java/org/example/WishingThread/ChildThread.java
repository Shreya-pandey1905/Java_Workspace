package org.example.WishingThread;

import java.util.Scanner;

public class ChildThread extends Thread{

    Display display;
    String name;


    public ChildThread(Display display, String name) {
        this.display = display;
        this.name = name;
    }



    @Override
    public void run() {
        try {
            display.wish(name);

        } catch (InterruptedException e) {
                throw new RuntimeException(e);
        }
    }


}
