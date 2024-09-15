package br.com.sdkopen.notificationemail.application.usecase;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@ConditionalOnProperty(name = "sdkopen.notification.email.enabled", havingValue = "true")
public class NotifierEmail {
  private final JavaMailSender javaMailSender;

  public void execute(Input input) {
    var message = new SimpleMailMessage();
    message.setFrom(input.getFromEmail());
    message.setTo(input.getToEmails().toArray(new String[0]));
    message.setSubject(input.getSubject());
    message.setText(input.getContent());
    javaMailSender.send(message);
  }

  @Data
  @Builder
  public static class Input {
    private String fromEmail;
    private List<String> toEmails;
    private String subject;
    private String content;
  }
}
