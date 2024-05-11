package br.com.senioritymeter.notification.interaction;

import br.com.senioritymeter.notification.enumeration.NotificationType;
import br.com.senioritymeter.notification.exception.NotificationException;
import br.com.senioritymeter.notification.interaction.creationoptions.NotificationCreationOption;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationCreation {
  private final List<NotificationCreationOption> options;

  public void execute(final Input input) {
    try {
      final var option =
          options.stream()
              .filter(o -> o.canApply(input.getType()))
              .findFirst()
              .orElseThrow(NotificationException::typeNotSupported);

      option.execute(input);
    } catch (Exception e) {
      throw NotificationException.with(e.getMessage());
    }
  }

  @Data
  @Builder
  public static class Input {
    private NotificationType type;
    private Email email;

    @Data
    @Builder
    public static class Email {
      private String fromEmail;
      private List<String> toEmails;
      private String subject;
      private String content;
    }
  }
}
