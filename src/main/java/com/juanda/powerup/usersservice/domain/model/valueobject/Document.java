package com.juanda.powerup.usersservice.domain.model.valueobject;


import com.juanda.powerup.usersservice.domain.exception.InvalidUserException;

import static com.juanda.powerup.usersservice.domain.message.UserValidationMessage.DOCUMENT_NUMERIC;
import static com.juanda.powerup.usersservice.domain.message.UserValidationMessage.DOCUMENT_REQUIRED;
import static com.juanda.powerup.usersservice.domain.pattern.UserValidationPattern.DOCUMENT_PATTERN;


public record Document(
        String value
) {

    public Document {

        if (value == null || value.isBlank()) {
            throw new InvalidUserException(
                    DOCUMENT_REQUIRED
            );
        }

        if (!value.matches(DOCUMENT_PATTERN)) {
            throw new InvalidUserException(
                    DOCUMENT_NUMERIC
            );
        }
    }
}