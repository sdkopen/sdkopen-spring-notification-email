<img src="https://github.com/SeniorityMeter/spring-sm-starter-bom/assets/36059306/ebfcb364-caea-48eb-972a-2d1ae63f4cdb" alt="logo" width="100"/>

# Seniority Meter
## Spring Notification

### Description
This library is a simple notification library for Spring Boot applications. It provides a simple way to send notifications to users.

___

### How to use
#### 1. Add the following dependency and repository to your `pom.xml` file:

```xml
<dependencies>
    <dependency>
        <groupId>br.com.senioritymeter</groupId>
        <artifactId>notification</artifactId>
        <version>1.0.0</version>
    </dependency>
</dependencies>
```
___

#### 2. Add the following properties to your `application.yaml` file:

##### a - Configuration for Email notification:
    
```yaml
spring:
  notification:
    email:
      enabled: ${NOTIFICATION_EMAIL_ENABLED:true}
      host: ${NOTIFICATION_EMAIL_HOST:smtp.gmail.com}
      port: ${NOTIFICATION_EMAIL_PORT:587}
      username: ${NOTIFICATION_EMAIL_USERNAME:username}
      password: ${NOTIFICATION_EMAIL_PASSWORD:password}
```

___

#### 3. Use the `NotificationCreation` to send notifications:

Inject the `NotificationCreation` bean in your class and use it to send notifications.
```java
private final NotificationCreation notificationCreation;
```

Prepare your payload and call the `execute` method of the `NotificationCreation` bean. Example:
```java
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
```
