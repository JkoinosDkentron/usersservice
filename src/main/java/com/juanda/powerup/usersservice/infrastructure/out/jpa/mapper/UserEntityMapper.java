package com.juanda.powerup.usersservice.infrastructure.out.jpa.mapper;

import com.juanda.powerup.usersservice.domain.model.Role;
import com.juanda.powerup.usersservice.domain.model.User;
import com.juanda.powerup.usersservice.infrastructure.out.jpa.entity.UserEntity;
import com.juanda.powerup.usersservice.infrastructure.out.jpa.entity.RoleEntity;
import org.springframework.stereotype.Component;

@Component
public class UserEntityMapper {

    public UserEntity toEntity(User user) {

        return UserEntity.builder()
                .id(user.getId())
                .name(user.getName())
                .lastName(user.getLastName())
                .document(user.getDocument())
                .phone(user.getPhone())
                .birthDate(user.getBirthDate())
                .email(user.getEmail())
                .password(user.getPassword())
                .role(RoleEntity.valueOf(user.getRole().name()))
                .build();
    }

    public User toDomain(UserEntity userEntity) {

        return User.restore(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getLastName(),
                userEntity.getDocument(),
                userEntity.getPhone(),
                userEntity.getBirthDate(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                Role.valueOf(userEntity.getRole().name())
        );
    }
}