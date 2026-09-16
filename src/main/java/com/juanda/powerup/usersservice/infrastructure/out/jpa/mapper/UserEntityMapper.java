package com.juanda.powerup.usersservice.infrastructure.out.jpa.mapper;

import com.juanda.powerup.usersservice.domain.model.Role;
import com.juanda.powerup.usersservice.domain.model.User;
import com.juanda.powerup.usersservice.infrastructure.out.jpa.entity.RoleEntity;
import com.juanda.powerup.usersservice.infrastructure.out.jpa.entity.UserEntity;
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
                .role(
                        mapRoleToEntity(user.getRole())
                )
                .build();
    }


    public User toDomain(UserEntity entity) {

        return User.restore(
                entity.getId(),
                entity.getName(),
                entity.getLastName(),
                entity.getDocument(),
                entity.getPhone(),
                entity.getBirthDate(),
                entity.getEmail(),
                entity.getPassword(),
                mapRoleToDomain(entity.getRole())
        );
    }


    private RoleEntity mapRoleToEntity(Role role) {

        return RoleEntity.valueOf(
                role.name()
        );
    }


    private Role mapRoleToDomain(RoleEntity roleEntity) {

        return Role.valueOf(
                roleEntity.name()
        );
    }
}