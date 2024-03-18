package com.opensourcelibrary.notification.interaction.creationoptions;

import com.opensourcelibrary.notification.enumeration.NotificationType;
import com.opensourcelibrary.notification.interaction.NotificationCreation;

public interface NotificationCreationOption {
  void execute(final NotificationCreation.Input input);

  boolean canApply(final NotificationType type);
}
