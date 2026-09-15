package com.juanda.powerup.usersservice.application.handler;

import com.juanda.powerup.usersservice.application.dto.request.CreateOwnerRequest;
import com.juanda.powerup.usersservice.application.dto.response.CreateOwnerResponse;
import com.juanda.powerup.usersservice.domain.api.IUserServicePort;
import com.juanda.powerup.usersservice.domain.model.User;
import com.juanda.powerup.usersservice.domain.spi.IPasswordEncoderPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateOwnerHandler implements IUserHandler {

    private final IUserServicePort userServicePort;
    private final IPasswordEncoderPort passwordEncoderPort;

    @Override
    public CreateOwnerResponse createOwner(CreateOwnerRequest request) {

        User user = User.createOwner(
                UUID.randomUUID(),
                request.name(),
                request.lastName(),
                request.document(),
                request.phone(),
                request.birthDate(),
                request.email(),
                passwordEncoderPort.encode(request.password())
        );

        User owner = userServicePort.createOwner(user);

        return new CreateOwnerResponse(
                owner.getId()
        );
    }
}