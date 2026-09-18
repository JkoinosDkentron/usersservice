package com.juanda.powerup.usersservice.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;


public record CreateOwnerRequest(

        @Schema(
                description = "User first name",
                example = "Juan",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        @NotBlank(
                message = "User name is required"
        )
        String name,


        @Schema(
                description = "User last name",
                example = "Vargas",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        @NotBlank(
                message = "User last name is required"
        )
        String lastName,


        @Schema(
                description = "User identification document",
                example = "123456789",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        @NotBlank(
                message = "User document is required"
        )
        @Pattern(
                regexp = "^\\d+$",
                message = "User document must be numeric"
        )
        String document,


        @Schema(
                description = "User phone number. Maximum 13 characters and optional + prefix",
                example = "+573001234567",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        @NotBlank(
                message = "User phone is required"
        )
        @Pattern(
                regexp = "^\\+?\\d{1,12}$",
                message = "User phone format is invalid"
        )
        String phone,


        @Schema(
                description = "User birth date. User must be an adult",
                example = "1995-01-01",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        @NotNull(
                message = "User birth date is required"
        )
        LocalDate birthDate,


        @Schema(
                description = "User email address",
                example = "juan.vargas@test.com",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        @NotBlank(
                message = "User email is required"
        )
        @Email(
                message = "User email format is invalid"
        )
        String email,


        @Schema(
                description = "User password",
                example = "********",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        @NotBlank(
                message = "User password is required"
        )
        String password

) {
}