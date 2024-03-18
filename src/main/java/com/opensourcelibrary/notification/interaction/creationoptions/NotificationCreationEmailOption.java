package com.opensourcelibrary.notification.interaction.creationoptions;

import com.opensourcelibrary.notification.enumeration.NotificationType;
import com.opensourcelibrary.notification.interaction.NotificationCreation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationCreationEmailOption implements NotificationCreationOption {
  @Value("${spring.notifcation.email.enabled}")
  private String enabled;

  @Override
  public void execute(NotificationCreation.Input input) {

  }

  @Override
  public boolean canApply(NotificationType type) {
    return NotificationType.EMAIL.equals(type) && Boolean.TRUE.equals(Boolean.valueOf(enabled));
  }
}
