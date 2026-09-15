package com.juanda.powerup.usersservice.application.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record CreateOwnerRequest(

        @NotBlank
        String name,

        @NotBlank
        String lastName,

        @NotBlank
        @Pattern(regexp = "\\d+")
        String document,

        @NotBlank
        @Pattern(
                regexp = "^\\+?\\d{1,13}$"
        )
        String phone,

        @NotNull
        LocalDate birthDate,

        @NotBlank
        @Email
        String email,

        @NotBlank
        String password

) {
}