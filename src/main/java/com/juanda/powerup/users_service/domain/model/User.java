package com.juanda.powerup.users_service.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Builder
@Value
public class User {

    private final UserId id;
    private String name;
    private String lastName;
    private String document;
    private String phone;
    private LocalDate birthDate;
    private String email;
    private String password;
    private final Role role;

    private User(UserId uuid,
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
            UserId id,
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
}