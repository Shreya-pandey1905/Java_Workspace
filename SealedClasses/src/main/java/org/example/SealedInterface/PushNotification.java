package org.example.SealedInterface;

public final class PushNotification implements Notification{
    @Override
    public void message() {
        System.out.println("mesage from push notification");
    }
}
