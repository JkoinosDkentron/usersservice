package com.juanda.powerup.usersservice.domain.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserTest {

    private static final LocalDate UNDERAGE_BIRTH_DATE =
            LocalDate.now(ZoneId.systemDefault())
                    .minusYears(17);

    private static final LocalDate ADULT_BIRTH_DATE =
            LocalDate.now(ZoneId.systemDefault())
                    .minusYears(20);

    @Test
    void shouldCreateOwnerWithOwnerRole() {

        User user = User.createOwner(
                UUID.randomUUID(),
                "Juan",
                "Vargas",
                "123456",
                "+573001234567",
                ADULT_BIRTH_DATE,
                "juan@test.com",
                "encrypted-password"
        );

        assertEquals(Role.OWNER, user.getRole());

    }

    @Test
    void shouldNotCreateOwnerWhenUserIsUnderAge() {
        assertThrows(
                IllegalArgumentException.class,
                this::createUnderAgeOwner
        );
    }

    private void createUnderAgeOwner() {
        User.createOwner(
                UUID.randomUUID(),
                "Juan",
                "Vargas",
                "123456",
                "+573001234567",
                UNDERAGE_BIRTH_DATE,
                "juan@test.com",
                "encrypted-password"
        );
    }
}