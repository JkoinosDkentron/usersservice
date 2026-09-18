package com.juanda.powerup.usersservice.mother;

import com.juanda.powerup.usersservice.domain.factory.UserFactory;
import com.juanda.powerup.usersservice.domain.model.CreateOwnerData;
import com.juanda.powerup.usersservice.domain.model.User;

import java.time.LocalDate;
import java.util.UUID;

public final class UserMother {


    private UserMother() {
    }


    public static User validOwner() {

        return UserFactory.createOwner(
                new CreateOwnerData(
                        UUID.randomUUID(),
                        "Juan",
                        "Vargas",
                        "123456",
                        "+573001234567",
                        adultBirthDate(),
                        "juan@test.com",
                        "encrypted-password"
                )
        );
    }


    public static UUID randomId() {

        return UUID.randomUUID();
    }


    public static LocalDate adultBirthDate() {

        return LocalDate.now()
                .minusYears(25);
    }


    public static LocalDate underAgeBirthDate() {

        return LocalDate.now()
                .minusYears(17);
    }
}