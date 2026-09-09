package com.juanda.powerup.users_service.infrastructure.output.persistence.repository;

import com.juanda.powerup.users_service.domain.model.User;
import com.juanda.powerup.users_service.domain.port.out.UserRepositoryPort;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryAdapter implements UserRepositoryPort {

    @Override
    public User save(User user) {
        return null;
    }
}
