package com.juanda.powerup.usersservice.application.mapper;

import com.juanda.powerup.usersservice.application.dto.request.CreateOwnerRequest;
import com.juanda.powerup.usersservice.domain.model.CreateOwnerData;

public interface IUserRequestMapper {

    CreateOwnerData toData(CreateOwnerRequest request);

}