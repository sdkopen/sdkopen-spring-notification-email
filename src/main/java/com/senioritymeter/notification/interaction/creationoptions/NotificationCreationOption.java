package com.senioritymeter.notification.interaction.creationoptions;

import com.senioritymeter.notification.enumeration.NotificationType;
import com.senioritymeter.notification.interaction.NotificationCreation;

public interface NotificationCreationOption {
  void execute(final NotificationCreation.Input input);

  boolean canApply(final NotificationType type);
}
