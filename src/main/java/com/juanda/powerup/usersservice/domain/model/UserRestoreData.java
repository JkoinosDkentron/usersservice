package com.juanda.powerup.usersservice.domain.model;

import com.juanda.powerup.usersservice.domain.model.valueobject.Document;
import com.juanda.powerup.usersservice.domain.model.valueobject.Email;
import com.juanda.powerup.usersservice.domain.model.valueobject.Phone;
import com.juanda.powerup.usersservice.domain.model.valueobject.UserId;

import java.time.LocalDate;


public record UserRestoreData(
        UserId id,
        String name,
        String lastName,
        Document document,
        Phone phone,
        LocalDate birthDate,
        Email email,
        String password,
        Role role
) {
}