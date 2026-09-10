package com.juanda.powerup.usersservice.domain.spi;

import com.juanda.powerup.usersservice.domain.model.User;

public interface IUserPersistencePort {

    User save(User user);

}