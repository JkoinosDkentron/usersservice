package com.juanda.powerup.usersservice.domain.model.valueobject;


import com.juanda.powerup.usersservice.domain.exception.InvalidUserException;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class UserIdTest {


    @Test
    void shouldCreateUserIdWithValidUuid() {


        UUID uuid =
                UUID.randomUUID();


        UserId userId =
                new UserId(uuid);


        assertEquals(
                uuid,
                userId.value()
        );
    }


    @Test
    void shouldThrowExceptionWhenUserIdIsNull() {


        assertThrows(
                InvalidUserException.class,
                () -> new UserId(null)
        );
    }
}