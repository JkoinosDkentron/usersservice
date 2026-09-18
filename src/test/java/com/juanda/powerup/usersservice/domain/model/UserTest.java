package com.juanda.powerup.usersservice.domain.model;

import com.juanda.powerup.usersservice.domain.exception.InvalidUserException;
import com.juanda.powerup.usersservice.domain.factory.UserFactory;
import com.juanda.powerup.usersservice.domain.model.valueobject.Document;
import com.juanda.powerup.usersservice.domain.model.valueobject.Email;
import com.juanda.powerup.usersservice.domain.model.valueobject.Phone;
import com.juanda.powerup.usersservice.mother.UserMother;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class UserTest {


    @Test
    void shouldCreateOwnerWithOwnerRole() {

        User user = UserMother.validOwner();

        assertEquals(
                Role.OWNER,
                user.getRole()
        );
    }


    @Test
    void shouldNotCreateOwnerWhenUserIsUnderAge() {

        CreateOwnerData data = validOwnerData(
                UserMother.underAgeBirthDate(),
                "123456",
                "+573001234567",
                "Juan",
                "Vargas",
                "juan@test.com",
                "encrypted-password"
        );

        assertInvalidUser(data);
    }


    @Test
    void shouldNotCreateOwnerWhenDocumentIsNotNumeric() {

        CreateOwnerData data = validOwnerData(
                UserMother.adultBirthDate(),
                "ABC123",
                "+573001234567",
                "Juan",
                "Vargas",
                "juan@test.com",
                "encrypted-password"
        );

        assertInvalidUser(data);
    }


    @Test
    void shouldNotCreateOwnerWhenPhoneFormatIsInvalid() {

        CreateOwnerData data = validOwnerData(
                UserMother.adultBirthDate(),
                "123456",
                "ABC123",
                "Juan",
                "Vargas",
                "juan@test.com",
                "encrypted-password"
        );

        assertInvalidUser(data);
    }


    @Test
    void shouldNotCreateOwnerWhenPhoneExceedsMaximumLength() {

        CreateOwnerData data = validOwnerData(
                UserMother.adultBirthDate(),
                "123456",
                "+57300123456789",
                "Juan",
                "Vargas",
                "juan@test.com",
                "encrypted-password"
        );

        assertInvalidUser(data);
    }


    @Test
    void shouldNotCreateOwnerWhenEmailIsInvalid() {

        CreateOwnerData data = validOwnerData(
                UserMother.adultBirthDate(),
                "123456",
                "+573001234567",
                "Juan",
                "Vargas",
                "juan.com",
                "encrypted-password"
        );

        assertInvalidUser(data);
    }


    @Test
    void shouldNotCreateOwnerWhenNameIsEmpty() {

        CreateOwnerData data = validOwnerData(
                UserMother.adultBirthDate(),
                "123456",
                "+573001234567",
                "",
                "Vargas",
                "juan@test.com",
                "encrypted-password"
        );

        assertInvalidUser(data);
    }


    @Test
    void shouldNotCreateOwnerWhenNameIsNull() {

        CreateOwnerData data = validOwnerData(
                UserMother.adultBirthDate(),
                "123456",
                "+573001234567",
                null,
                "Vargas",
                "juan@test.com",
                "encrypted-password"
        );

        assertInvalidUser(data);
    }


    @Test
    void shouldNotCreateOwnerWhenLastNameIsEmpty() {

        CreateOwnerData data = validOwnerData(
                UserMother.adultBirthDate(),
                "123456",
                "+573001234567",
                "Juan",
                "",
                "juan@test.com",
                "encrypted-password"
        );

        assertInvalidUser(data);
    }


    @Test
    void shouldNotCreateOwnerWhenDocumentIsEmpty() {

        CreateOwnerData data = validOwnerData(
                UserMother.adultBirthDate(),
                "",
                "+573001234567",
                "Juan",
                "Vargas",
                "juan@test.com",
                "encrypted-password"
        );

        assertInvalidUser(data);
    }


    @Test
    void shouldNotCreateOwnerWhenPhoneIsEmpty() {

        CreateOwnerData data = validOwnerData(
                UserMother.adultBirthDate(),
                "123456",
                "",
                "Juan",
                "Vargas",
                "juan@test.com",
                "encrypted-password"
        );

        assertInvalidUser(data);
    }


    @Test
    void shouldNotCreateOwnerWhenBirthDateIsNull() {

        CreateOwnerData data = validOwnerData(
                null,
                "123456",
                "+573001234567",
                "Juan",
                "Vargas",
                "juan@test.com",
                "encrypted-password"
        );

        assertInvalidUser(data);
    }


    @Test
    void shouldNotCreateOwnerWhenEmailIsEmpty() {

        CreateOwnerData data = validOwnerData(
                UserMother.adultBirthDate(),
                "123456",
                "+573001234567",
                "Juan",
                "Vargas",
                "",
                "encrypted-password"
        );

        assertInvalidUser(data);
    }


    @Test
    void shouldNotCreateOwnerWhenPasswordIsEmpty() {

        CreateOwnerData data = validOwnerData(
                UserMother.adultBirthDate(),
                "123456",
                "+573001234567",
                "Juan",
                "Vargas",
                "juan@test.com",
                ""
        );

        assertInvalidUser(data);
    }


    private void assertInvalidUser(
            CreateOwnerData data
    ) {

        assertThrows(
                InvalidUserException.class,
                () -> UserFactory.createOwner(data)
        );
    }


    private CreateOwnerData validOwnerData(
            java.time.LocalDate birthDate,
            String document,
            String phone,
            String name,
            String lastName,
            String email,
            String password
    ) {

        return new CreateOwnerData(
                UserMother.randomId(),
                name,
                lastName,
                document,
                phone,
                birthDate,
                email,
                password
        );
    }

    @Test
    void shouldCreateOwnerWithCorrectInformation(){

        User user = UserMother.validOwner();

        assertEquals("Juan", user.getName());
        assertEquals("Vargas", user.getLastName());
        assertEquals("123456", user.getDocument().value());
        assertEquals("+573001234567", user.getPhone().value());
        assertEquals("juan@test.com", user.getEmail().value());
    }

    @Test
    void shouldThrowExceptionWhenUserDataIsNull() {


        assertThrows(
                InvalidUserException.class,
                () -> new User(null)
        );

    }

    @Test
    void shouldThrowExceptionWhenUserIdIsNull() {


        UserData data =
                new UserData(
                        null,
                        "Juan",
                        "Vargas",
                        new Document("123456"),
                        new Phone("+573001234567"),
                        UserMother.adultBirthDate(),
                        new Email("juan@test.com"),
                        "password",
                        Role.OWNER
                );


        assertThrows(
                InvalidUserException.class,
                () -> new User(data)
        );

    }
}