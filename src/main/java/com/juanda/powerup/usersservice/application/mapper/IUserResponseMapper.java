package com.juanda.powerup.usersservice.application.mapper;

import com.juanda.powerup.usersservice.application.dto.response.CreateOwnerResponse;
import com.juanda.powerup.usersservice.domain.model.User;

public interface IUserResponseMapper {

    CreateOwnerResponse toResponse(
            User user
    );

}