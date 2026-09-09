package com.juanda.powerup.users_service.infrastructure.input.rest.dto;

import java.time.LocalDate;

public record CreateOwnerRequest(
        String name,
        String lastName,
        String document,
        String phone,
        LocalDate birthDate,
        String email,
        String password
) {}