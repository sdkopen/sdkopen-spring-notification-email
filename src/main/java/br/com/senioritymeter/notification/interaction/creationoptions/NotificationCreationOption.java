package br.com.senioritymeter.notification.interaction.creationoptions;

import br.com.senioritymeter.notification.enumeration.NotificationType;
import br.com.senioritymeter.notification.interaction.NotificationCreation;

public interface NotificationCreationOption {
  void execute(final NotificationCreation.Input input);

  boolean canApply(final NotificationType type);
}
