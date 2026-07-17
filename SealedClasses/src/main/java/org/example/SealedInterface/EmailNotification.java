package org.example.SealedInterface;

public final class EmailNotification implements Notification {
    @Override
    public void message() {
        System.out.println("message using notification");
    }
}
