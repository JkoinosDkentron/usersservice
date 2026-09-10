package com.juanda.powerup.usersservice.infrastructure.out.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "users")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    private UUID id;

    private String name;

    private String lastName;

    private String document;

    private String phone;

    private LocalDate birthDate;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private RoleEntity role;
}