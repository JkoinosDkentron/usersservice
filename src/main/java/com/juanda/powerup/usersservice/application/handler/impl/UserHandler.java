package com.juanda.powerup.usersservice.application.handler.impl;

import com.juanda.powerup.usersservice.application.dto.request.CreateOwnerRequest;
import com.juanda.powerup.usersservice.application.dto.response.CreateOwnerResponse;
import com.juanda.powerup.usersservice.application.handler.IUserHandler;
import com.juanda.powerup.usersservice.application.mapper.IUserRequestMapper;
import com.juanda.powerup.usersservice.application.mapper.IUserResponseMapper;
import com.juanda.powerup.usersservice.domain.api.IUserServicePort;
import com.juanda.powerup.usersservice.domain.model.CreateOwnerData;
import com.juanda.powerup.usersservice.domain.model.User;
import org.springframework.stereotype.Service;


@Service
public class UserHandler implements IUserHandler {


    private final IUserServicePort userServicePort;
    private final IUserRequestMapper userRequestMapper;
    private final IUserResponseMapper userResponseMapper;


    public UserHandler(
            IUserServicePort userServicePort,
            IUserRequestMapper userRequestMapper,
            IUserResponseMapper userResponseMapper
    ) {
        this.userServicePort = userServicePort;
        this.userRequestMapper = userRequestMapper;
        this.userResponseMapper = userResponseMapper;
    }


    @Override
    public CreateOwnerResponse createOwner(
            CreateOwnerRequest request
    ) {

        CreateOwnerData data =
                userRequestMapper.toData(request);


        User createdUser =
                userServicePort.createOwner(data);


        return userResponseMapper.toResponse(createdUser);
    }
}