package com.juanda.powerup.usersservice.domain.model.valueobject;

import com.juanda.powerup.usersservice.domain.exception.InvalidUserException;

import java.util.UUID;

import static com.juanda.powerup.usersservice.domain.message.UserValidationMessage.USER_ID_NOT_NULL;

public record UserId(
        UUID value
) {

    public UserId {

        if (value == null) {
            throw new InvalidUserException(
                    USER_ID_NOT_NULL
            );
        }
    }
}