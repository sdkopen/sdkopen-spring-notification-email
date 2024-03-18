package com.opensourcelibrary.notification;

import com.opensourcelibrary.notification.enumeration.NotificationType;
import com.opensourcelibrary.notification.interaction.NotificationCreation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sent")
@RequiredArgsConstructor
public class Test {
  private final NotificationCreation notificationCreation;

  @GetMapping
  public void sent() {
    final var input =
        NotificationCreation.Input.builder()
            .email(
                NotificationCreation.Input.Email.builder()
                    .content("Test")
                    .fromEmail("portfoliodeveloper@gmail.com")
                    .subject("Portfolio Developer - Email Confirmation")
                    .toEmails(List.of("luizfernandesoliveiraoficial@gmail.com"))
                    .build())
            .type(NotificationType.EMAIL)
            .build();

    notificationCreation.execute(input);
  }
}
