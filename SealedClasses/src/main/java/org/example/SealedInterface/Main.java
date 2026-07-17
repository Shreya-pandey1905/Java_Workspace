package org.example.SealedInterface;

public class Main {
    static void main() {
        EmailNotification emailNotification= new EmailNotification();
        PushNotification pushNotification= new PushNotification();
        SMSNotification smsNotification = new SMSNotification();

        emailNotification.message();
        pushNotification.message();
        smsNotification.message();
    }
}
