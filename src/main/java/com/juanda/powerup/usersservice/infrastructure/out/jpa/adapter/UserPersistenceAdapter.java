package com.juanda.powerup.usersservice.infrastructure.out.jpa.adapter;

import com.juanda.powerup.usersservice.domain.model.User;
import com.juanda.powerup.usersservice.domain.spi.IUserPersistencePort;
import com.juanda.powerup.usersservice.infrastructure.out.jpa.entity.UserEntity;
import com.juanda.powerup.usersservice.infrastructure.out.jpa.mapper.UserEntityMapper;
import com.juanda.powerup.usersservice.infrastructure.out.jpa.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements IUserPersistencePort {

    private final UserJpaRepository userJpaRepository;
    private final UserEntityMapper userEntityMapper;

    @Override
    public User save(User user) {

        UserEntity entity = userEntityMapper.toEntity(user);

        UserEntity saved = userJpaRepository.save(entity);

        return userEntityMapper.toDomain(saved);
    }

    @Override
    public Optional<User> findById(UUID userId) {
        return userJpaRepository.findById(userId)
                .map(userEntityMapper::toDomain);
    }
}