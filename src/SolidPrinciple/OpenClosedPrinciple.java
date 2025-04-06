package SolidPrinciple;

import java.util.List;

// Step 1: Create an interface
interface Notification {
    void send(String message);
}

// Step 2: Implement different notifications
class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}

class SmsNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

// Step 3: Extend without modification
class PushNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Sending Push Notification: " + message);
    }
}

// Step 4: Notification service
class NotificationService {
    private final List<Notification> notifications;

    public NotificationService(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public void sendNotifications(String message) {
        notifications.forEach(notification -> notification.send(message));
    }
}
//        New notification types can be added by implementing the Notification interface.
//
//        No need to modify the NotificationService class.
//
//        Extensible, flexible, and easier to maintain.
//        Open for Extension: You can add new functionality.
//
//        Closed for Modification: You shouldn’t change existing code when adding new features.

public class OpenClosedPrinciple {
    public static void main(String[] args) {

    }
}
