package com.opensourcelibrary.notification.exception;

public class NotificationException extends RuntimeException {

  private NotificationException(String message) {
    super(message);
  }

  public static NotificationException typeNotSupported() {
    return new NotificationException("Notification type not supported");
  }

  public static NotificationException with(String message) {
    return new NotificationException(message);
  }
}
