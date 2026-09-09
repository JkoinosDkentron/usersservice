package com.juanda.powerup.users_service.infrastructure.output.generator;

import com.juanda.powerup.users_service.domain.model.UserId;
import com.juanda.powerup.users_service.domain.port.out.IdGeneratorPort;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UuidGeneratorAdapter implements IdGeneratorPort {
    @Override
    public UserId generate() {
        return UserId.create(UUID.randomUUID());
    }
}
