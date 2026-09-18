package com.juanda.powerup.usersservice.domain.model.valueobject;

import com.juanda.powerup.usersservice.domain.exception.InvalidUserException;

import static com.juanda.powerup.usersservice.domain.message.UserValidationMessage.EMAIL_FORMAT;
import static com.juanda.powerup.usersservice.domain.message.UserValidationMessage.EMAIL_REQUIRED;
import static com.juanda.powerup.usersservice.domain.pattern.UserValidationPattern.EMAIL_PATTERN;


public record Email(
        String value
) {

    public Email {

        if (value == null || value.isBlank()) {
            throw new InvalidUserException(
                    EMAIL_REQUIRED
            );
        }

        if (!value.matches(EMAIL_PATTERN)) {
            throw new InvalidUserException(
                    EMAIL_FORMAT
            );
        }
    }
}