package com.juanda.powerup.usersservice.application.mapper;

import com.juanda.powerup.usersservice.application.dto.request.CreateOwnerRequest;
import com.juanda.powerup.usersservice.domain.model.User;

public interface IUserRequestMapper {

    User toDomain(
            CreateOwnerRequest request
    );

}