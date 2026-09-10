package com.juanda.powerup.usersservice.domain.model;

import java.time.LocalDate;
import java.util.UUID;

public class User {

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