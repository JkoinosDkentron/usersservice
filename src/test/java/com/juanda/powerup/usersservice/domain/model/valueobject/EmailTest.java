package com.juanda.powerup.usersservice.domain.model.valueobject;

import com.juanda.powerup.usersservice.domain.exception.InvalidUserException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmailTest {


    @Test
    void shouldCreateValidEmail(){

        Email email = new Email(
                "juan@test.com"
        );

        assertEquals(
                "juan@test.com",
                email.value()
        );
    }


    @Test
    void shouldRejectInvalidEmail(){

        assertThrows(
                InvalidUserException.class,
                () -> new Email("juan.com")
        );
    }
}