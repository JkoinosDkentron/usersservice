package com.juanda.powerup.usersservice.application.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CreateOwnerRequest(

        @NotBlank
        String name,

        @NotBlank
        String lastName,

        @NotBlank
        String document,

        @NotBlank
        String phone,

        @NotNull
        LocalDate birthDate,

        @Email
        String email,

        @NotBlank
        String password

) {}