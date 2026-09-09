package com.juanda.powerup.users_service.application.dto;

import java.time.LocalDate;

public record CreateOwnerCommand(
        String name,
        String lastName,
        String document,
        String phone,
        LocalDate birthDate,
        String email,
        String password
) {
}