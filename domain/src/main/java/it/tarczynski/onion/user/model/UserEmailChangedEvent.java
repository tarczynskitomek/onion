package it.tarczynski.onion.user.model;

import lombok.Value;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Value
public class UserEmailChangedEvent {
    String oldEmail;
    String newEmail;
    LocalDateTime eventTime = LocalDateTime.now(ZoneId.of("UTC"));
}