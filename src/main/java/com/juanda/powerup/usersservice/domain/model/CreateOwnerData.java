package com.juanda.powerup.usersservice.domain.model;

import java.time.LocalDate;
import java.util.UUID;

public record CreateOwnerData(

        UUID id,
        String name,
        String lastName,
        String document,
        String phone,
        LocalDate birthDate,
        String email,
        String password

) {


    public CreateOwnerData withPassword(
            String encryptedPassword
    ){

        return new CreateOwnerData(
                id,
                name,
                lastName,
                document,
                phone,
                birthDate,
                email,
                encryptedPassword
        );
    }
}