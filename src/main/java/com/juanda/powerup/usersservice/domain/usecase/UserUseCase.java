package com.juanda.powerup.usersservice.domain.usecase;

import com.juanda.powerup.usersservice.domain.api.IUserServicePort;
import com.juanda.powerup.usersservice.domain.factory.UserFactory;
import com.juanda.powerup.usersservice.domain.model.CreateOwnerData;
import com.juanda.powerup.usersservice.domain.model.User;
import com.juanda.powerup.usersservice.domain.spi.IPasswordEncoderPort;
import com.juanda.powerup.usersservice.domain.spi.IUserPersistencePort;

public class UserUseCase implements IUserServicePort {


    private final IUserPersistencePort userPersistencePort;
    private final IPasswordEncoderPort passwordEncoderPort;


    public UserUseCase(
            IUserPersistencePort userPersistencePort,
            IPasswordEncoderPort passwordEncoderPort
    ) {
        this.userPersistencePort = userPersistencePort;
        this.passwordEncoderPort = passwordEncoderPort;
    }


    @Override
    public User createOwner(
            CreateOwnerData data
    ) {

        String encryptedPassword =
                passwordEncoderPort.encode(
                        data.password()
                );


        User user =
                UserFactory.createOwner(
                        data.withPassword(encryptedPassword)
                );


        return userPersistencePort.save(user);
    }
}