package com.juanda.powerup.usersservice.domain.api;

import com.juanda.powerup.usersservice.domain.model.CreateOwnerData;
import com.juanda.powerup.usersservice.domain.model.User;

public interface IUserServicePort {

    User createOwner(CreateOwnerData data);

}