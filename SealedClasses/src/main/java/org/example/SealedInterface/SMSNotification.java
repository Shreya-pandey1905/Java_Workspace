package org.example.SealedInterface;

public final class SMSNotification implements Notification{
    @Override
    public void message() {
        System.out.println("message using Notifictaion");
    }
}
