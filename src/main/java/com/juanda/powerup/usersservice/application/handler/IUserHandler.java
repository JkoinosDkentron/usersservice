package com.juanda.powerup.usersservice.application.handler;

import com.juanda.powerup.usersservice.application.dto.request.CreateOwnerRequest;
import com.juanda.powerup.usersservice.application.dto.response.CreateOwnerResponse;
import com.juanda.powerup.usersservice.application.dto.response.OwnerValidationResponse;

import java.util.UUID;

public interface IUserHandler {

    CreateOwnerResponse createOwner(CreateOwnerRequest request);

    OwnerValidationResponse isOwner(UUID userId);
}