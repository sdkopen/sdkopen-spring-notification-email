<img src="https://github.com/user-attachments/assets/801ecb0c-455c-41a8-bb52-15d4318f2e78" alt="logo" width="100" style="border-radius: 50%;" />

# SDK Open
## Spring Notification Email

### Description
This is a simple notification email SDK for Spring Boot applications.

___

### How to use
#### 1. Add the following parent to your `pom.xml` file:

```xml
<parent>
    <groupId>br.com.sdkopen</groupId>
    <artifactId>parent</artifactId>
    <version>1.0.0</version>
</parent>
```
___

#### 2. add scanBasePackages to your SpringBootApplication
```java
@SpringBootApplication(scanBasePackages = {"br.com.sdkopen", "your.package.name.here"})
```
___

#### 3. Add the following dependency to your `pom.xml` file:

```xml
<dependencies>
    <dependency>
        <groupId>br.com.sdkopen</groupId>
        <artifactId>notification-email</artifactId>
        <version>1.0.0</version>
    </dependency>
</dependencies>
```
___

#### 4. Add the following properties to your `application.yaml` file:

##### a - Configuration for Email notification:
    
```yaml
sdkopen:
  notification:
    email:
      enabled: ${NOTIFICATION_EMAIL_ENABLED:true}
      host: ${NOTIFICATION_EMAIL_HOST:smtp.gmail.com}
      port: ${NOTIFICATION_EMAIL_PORT:587}
      username: ${NOTIFICATION_EMAIL_USERNAME:username}
      password: ${NOTIFICATION_EMAIL_PASSWORD:password}
```

___

#### 5. Use the `NotifierEmail` to send notifications:

Inject the `NotifierEmail` bean in your class and use it to send notifications.
```java
private final NotifierEmail notifierEmail;
```

Prepare your payload and call the `execute` method of the `NotifierEmail` bean. Example:
```java
final var input =
    NotifierEmail.Input.builder()
        .content("Test")
        .fromEmail("luizfernandesoliveiraoficial@gmail.com")
        .subject("Portfolio Developer - Email Confirmation")
        .toEmails(List.of("you@gmail.com"))
        .build();

notifierEmail.execute(input);
```
