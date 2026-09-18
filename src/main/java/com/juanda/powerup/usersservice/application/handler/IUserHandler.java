package com.juanda.powerup.usersservice.application.handler;

import com.juanda.powerup.usersservice.application.dto.request.CreateOwnerRequest;
import com.juanda.powerup.usersservice.application.dto.response.CreateOwnerResponse;

public interface IUserHandler {

    CreateOwnerResponse createOwner(CreateOwnerRequest request);

}