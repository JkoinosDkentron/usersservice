package com.juanda.powerup.usersservice.domain.usecase;

import com.juanda.powerup.usersservice.domain.api.IUserServicePort;
import com.juanda.powerup.usersservice.domain.model.User;
import com.juanda.powerup.usersservice.domain.spi.IUserPersistencePort;

public class UserUseCase implements IUserServicePort {


    private final IUserPersistencePort userPersistencePort;


    public UserUseCase(
            IUserPersistencePort userPersistencePort
    ) {
        this.userPersistencePort = userPersistencePort;
    }


    @Override
    public User createOwner(
            User user
    ) {

        return userPersistencePort.save(user);
    }
}