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


    @Column(nullable = false)
    private String name;


    @Column(nullable = false)
    private String lastName;


    @Column(nullable = false, unique = true)
    private String document;


    @Column(nullable = false)
    private String phone;


    @Column(nullable = false)
    private LocalDate birthDate;


    @Column(nullable = false, unique = true)
    private String email;


    @Column(nullable = false)
    private String password;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoleEntity role;
}