package com.juanda.powerup.usersservice.domain.spi;

import com.juanda.powerup.usersservice.domain.model.User;

import java.util.Optional;
import java.util.UUID;

public interface IUserPersistencePort {

    User save(User user);

    Optional<User> findById(UUID userId);

}