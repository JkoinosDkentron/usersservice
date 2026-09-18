package com.juanda.powerup.usersservice.domain.model.valueobject;

import com.juanda.powerup.usersservice.domain.exception.InvalidUserException;

import static com.juanda.powerup.usersservice.domain.message.UserValidationMessage.*;
import static com.juanda.powerup.usersservice.domain.pattern.UserValidationPattern.PHONE_PATTERN;
import static com.juanda.powerup.usersservice.domain.rule.UserValidationRule.MAX_PHONE_LENGTH;


public record Phone(
        String value
) {

    public Phone {

        if (value == null || value.isBlank()) {
            throw new InvalidUserException(
                    PHONE_REQUIRED
            );
        }

        if (!value.matches(PHONE_PATTERN)) {
            throw new InvalidUserException(
                    PHONE_FORMAT
            );
        }

        if (value.length() > MAX_PHONE_LENGTH) {
            throw new InvalidUserException(
                    PHONE_MAX_LENGTH
            );
        }
    }
}