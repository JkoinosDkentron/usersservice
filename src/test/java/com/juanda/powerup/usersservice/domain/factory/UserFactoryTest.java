package com.juanda.powerup.usersservice.domain.factory;


import com.juanda.powerup.usersservice.domain.model.Role;
import com.juanda.powerup.usersservice.domain.model.User;
import com.juanda.powerup.usersservice.domain.model.UserRestoreData;
import com.juanda.powerup.usersservice.domain.model.valueobject.Document;
import com.juanda.powerup.usersservice.domain.model.valueobject.Email;
import com.juanda.powerup.usersservice.domain.model.valueobject.Phone;
import com.juanda.powerup.usersservice.domain.model.valueobject.UserId;
import com.juanda.powerup.usersservice.mother.UserMother;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class UserFactoryTest {


    @Test
    void shouldRestoreUserWithExistingRole() {


        User user =
                UserFactory.restore(
                        new UserRestoreData(
                                new UserId(
                                        UserMother.randomId()
                                ),
                                "Juan",
                                "Vargas",
                                new Document(
                                        "123456"
                                ),
                                new Phone(
                                        "+573001234567"
                                ),
                                UserMother.adultBirthDate(),
                                new Email(
                                        "juan@test.com"
                                ),
                                "encrypted-password",
                                Role.OWNER
                        )
                );


        assertEquals(
                Role.OWNER,
                user.getRole()
        );


        assertEquals(
                "Juan",
                user.getName()
        );


        assertEquals(
                "juan@test.com",
                user.getEmail().value()
        );
    }
}