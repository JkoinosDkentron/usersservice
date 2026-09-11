package com.juanda.powerup.usersservice.domain.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.UUID;

public class User {

    private static final int MINIMUM_OWNER_AGE = 18;

    private UUID id;
    private String name;
    private String lastName;
    private String document;
    private String phone;
    private LocalDate birthDate;
    private String email;
    private String password;
    private Role role;

    private User(UUID uuid,
                 String name,
                 String lastName,
                 String document,
                 String phone,
                 LocalDate birthDate,
                 String email,
                 String password,
                 Role role) {
        this.id = uuid;
        this.name = name;
        this.lastName = lastName;
        this.document = document;
        this.phone = phone;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public static User createOwner(
            UUID id,
            String name,
            String lastName,
            String document,
            String phone,
            LocalDate birthDate,
            String email,
            String password
    ) {

        validateAdult(birthDate);

        return new User(
                id,
                name,
                lastName,
                document,
                phone,
                birthDate,
                email,
                password,
                Role.OWNER
        );
    }

    private static void validateAdult(LocalDate birthDate) {

        int age = Period
                .between(
                        birthDate,
                        LocalDate.now(ZoneId.systemDefault())
                )
                .getYears();

        if (age < MINIMUM_OWNER_AGE) {
            throw new IllegalArgumentException(
                    "User must be adult"
            );
        }
    }
    public static User restore(
            UUID id,
            String name,
            String lastName,
            String document,
            String phone,
            LocalDate birthDate,
            String email,
            String password,
            Role role
    ) {
        return new User(
                id,
                name,
                lastName,
                document,
                phone,
                birthDate,
                email,
                password,
                role
        );
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDocument() {
        return document;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }
}