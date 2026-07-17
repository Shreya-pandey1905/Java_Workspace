package org.example.SealedInterface;

public sealed interface Notification permits EmailNotification,SMSNotification,PushNotification {
    void message();
}
