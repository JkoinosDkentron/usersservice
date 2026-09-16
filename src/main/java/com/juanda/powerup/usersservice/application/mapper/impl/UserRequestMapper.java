package com.juanda.powerup.usersservice.application.mapper.impl;

import com.juanda.powerup.usersservice.application.dto.request.CreateOwnerRequest;
import com.juanda.powerup.usersservice.application.mapper.IUserRequestMapper;
import com.juanda.powerup.usersservice.domain.model.User;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserRequestMapper implements IUserRequestMapper {


    @Override
    public User toDomain(
            CreateOwnerRequest request
    ) {

        return User.createOwner(
                UUID.randomUUID(),
                request.name(),
                request.lastName(),
                request.document(),
                request.phone(),
                request.birthDate(),
                request.email(),
                request.password()
        );
    }
}