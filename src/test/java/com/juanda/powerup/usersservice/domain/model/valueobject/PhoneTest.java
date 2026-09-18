package com.juanda.powerup.usersservice.domain.model.valueobject;


import com.juanda.powerup.usersservice.domain.exception.InvalidUserException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class PhoneTest {


    @Test
    void shouldCreatePhoneWithValidNumber() {


        Phone phone =
                new Phone("+573001234567");


        assertEquals(
                "+573001234567",
                phone.value()
        );
    }


    @Test
    void shouldCreatePhoneWithoutCountrySymbol() {


        Phone phone =
                new Phone("573001234567");


        assertEquals(
                "573001234567",
                phone.value()
        );
    }


    @Test
    void shouldThrowExceptionWhenPhoneIsNull() {


        assertThrows(
                InvalidUserException.class,
                () -> new Phone(null)
        );
    }


    @Test
    void shouldThrowExceptionWhenPhoneIsEmpty() {


        assertThrows(
                InvalidUserException.class,
                () -> new Phone("")
        );
    }


    @Test
    void shouldThrowExceptionWhenPhoneContainsLetters() {


        assertThrows(
                InvalidUserException.class,
                () -> new Phone("+57300ABC123")
        );
    }


    @Test
    void shouldThrowExceptionWhenPhoneExceedsMaximumLength() {


        assertThrows(
                InvalidUserException.class,
                () -> new Phone("+57300123456789")
        );
    }
}