package com.opensourcelibrary.notification.interaction.creationoptions;

import com.opensourcelibrary.notification.enumeration.NotificationType;
import com.opensourcelibrary.notification.interaction.NotificationCreation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationCreationEmailOption implements NotificationCreationOption {
  private final JavaMailSender javaMailSender;

  @Value("${spring.notification.email.enabled}")
  private String enabled;

  @Override
  public void execute(NotificationCreation.Input input) {
    final var email = input.getEmail();
    var message = new SimpleMailMessage();
    message.setFrom(email.getFromEmail());
    message.setTo(email.getToEmails().toArray(new String[0]));
    message.setSubject(email.getSubject());
    message.setText(email.getContent());
    javaMailSender.send(message);
  }

  @Override
  public boolean canApply(NotificationType type) {
    return NotificationType.EMAIL.equals(type) && Boolean.TRUE.equals(Boolean.valueOf(enabled));
  }
}
