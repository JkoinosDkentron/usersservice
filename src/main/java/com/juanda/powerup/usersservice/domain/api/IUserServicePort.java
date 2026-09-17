package com.juanda.powerup.usersservice.domain.api;

import com.juanda.powerup.usersservice.domain.model.User;

import java.util.UUID;

public interface IUserServicePort {

    User createOwner(User user);

    boolean isOwner(UUID userId);

}