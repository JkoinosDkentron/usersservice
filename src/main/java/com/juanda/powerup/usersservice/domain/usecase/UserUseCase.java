package com.juanda.powerup.usersservice.domain.usecase;

import com.juanda.powerup.usersservice.domain.api.IUserServicePort;
import com.juanda.powerup.usersservice.domain.model.Role;
import com.juanda.powerup.usersservice.domain.model.User;
import com.juanda.powerup.usersservice.domain.spi.IPasswordEncoderPort;
import com.juanda.powerup.usersservice.domain.spi.IUserPersistencePort;

import java.util.UUID;

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
    public User createOwner(User user) {

        String encodedPassword =
                passwordEncoderPort.encode(user.getPassword());

        User owner = User.createOwner(
                user.getId(),
                user.getName(),
                user.getLastName(),
                user.getDocument(),
                user.getPhone(),
                user.getBirthDate(),
                user.getEmail(),
                encodedPassword
        );

        return userPersistencePort.save(owner);
    }

    @Override
    public boolean isOwner(UUID userId) {
        return userPersistencePort.findById(userId)
                .map(user -> user.getRole() == Role.OWNER)
                .orElse(false);
    }
}