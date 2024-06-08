package br.com.senioritymeter.notification.interaction.creationoptions;

import br.com.senioritymeter.notification.enumeration.NotificationType;
import br.com.senioritymeter.notification.interaction.NotificationCreation;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@ConditionalOnProperty(name = "spring.notification.email.enabled", havingValue = "true")
public class NotificationCreationEmailOption implements NotificationCreationOption {
  private final JavaMailSender javaMailSender;

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
    return NotificationType.EMAIL.equals(type);
  }
}
