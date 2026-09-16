package com.juanda.powerup.usersservice.application.mapper.impl;

import com.juanda.powerup.usersservice.application.dto.response.CreateOwnerResponse;
import com.juanda.powerup.usersservice.application.mapper.IUserResponseMapper;
import com.juanda.powerup.usersservice.domain.model.User;
import org.springframework.stereotype.Component;


@Component
public class UserResponseMapper implements IUserResponseMapper {


    @Override
    public CreateOwnerResponse toResponse(
            User user
    ) {

        return new CreateOwnerResponse(
                user.getId()
        );
    }
}