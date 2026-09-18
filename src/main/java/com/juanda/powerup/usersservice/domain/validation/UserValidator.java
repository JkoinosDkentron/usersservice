package com.juanda.powerup.usersservice.domain.validation;


import com.juanda.powerup.usersservice.domain.exception.InvalidUserException;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

import static com.juanda.powerup.usersservice.domain.message.UserValidationMessage.BIRTH_DATE_REQUIRED;
import static com.juanda.powerup.usersservice.domain.message.UserValidationMessage.LAST_NAME_REQUIRED;
import static com.juanda.powerup.usersservice.domain.message.UserValidationMessage.NAME_REQUIRED;
import static com.juanda.powerup.usersservice.domain.message.UserValidationMessage.PASSWORD_REQUIRED;
import static com.juanda.powerup.usersservice.domain.message.UserValidationMessage.USER_MUST_BE_ADULT;
import static com.juanda.powerup.usersservice.domain.rule.UserValidationRule.MINIMUM_OWNER_AGE;


public final class UserValidator {


    private UserValidator() {
    }


    public static void validateOwner(
            String name,
            String lastName,
            LocalDate birthDate,
            String password
    ) {


        validateRequiredFields(
                name,
                lastName,
                birthDate,
                password
        );


        validateAdult(
                birthDate
        );
    }


    private static void validateRequiredFields(
            String name,
            String lastName,
            LocalDate birthDate,
            String password
    ) {


        if (name == null || name.isBlank()) {

            throw new InvalidUserException(
                    NAME_REQUIRED
            );
        }


        if (lastName == null || lastName.isBlank()) {

            throw new InvalidUserException(
                    LAST_NAME_REQUIRED
            );
        }


        if (birthDate == null) {

            throw new InvalidUserException(
                    BIRTH_DATE_REQUIRED
            );
        }


        if (password == null || password.isBlank()) {

            throw new InvalidUserException(
                    PASSWORD_REQUIRED
            );
        }
    }


    private static void validateAdult(
            LocalDate birthDate
    ) {


        int age =
                Period.between(
                                birthDate,
                                LocalDate.now(
                                        ZoneId.systemDefault()
                                )
                        )
                        .getYears();


        if (age < MINIMUM_OWNER_AGE) {

            throw new InvalidUserException(
                    USER_MUST_BE_ADULT
            );
        }
    }
}