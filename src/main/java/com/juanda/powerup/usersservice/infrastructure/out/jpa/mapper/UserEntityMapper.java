package com.juanda.powerup.usersservice.infrastructure.out.jpa.mapper;


import com.juanda.powerup.usersservice.domain.factory.UserFactory;
import com.juanda.powerup.usersservice.domain.model.Role;
import com.juanda.powerup.usersservice.domain.model.User;
import com.juanda.powerup.usersservice.domain.model.UserRestoreData;
import com.juanda.powerup.usersservice.domain.model.valueobject.Document;
import com.juanda.powerup.usersservice.domain.model.valueobject.Email;
import com.juanda.powerup.usersservice.domain.model.valueobject.Phone;
import com.juanda.powerup.usersservice.domain.model.valueobject.UserId;
import com.juanda.powerup.usersservice.infrastructure.out.jpa.entity.RoleEntity;
import com.juanda.powerup.usersservice.infrastructure.out.jpa.entity.UserEntity;
import org.springframework.stereotype.Component;


@Component
public class UserEntityMapper {


    public UserEntity toEntity(
            User user
    ) {

        return UserEntity.builder()
                .id(
                        user.getId().value()
                )
                .name(
                        user.getName()
                )
                .lastName(
                        user.getLastName()
                )
                .document(
                        user.getDocument().value()
                )
                .phone(
                        user.getPhone().value()
                )
                .birthDate(
                        user.getBirthDate()
                )
                .email(
                        user.getEmail().value()
                )
                .password(
                        user.getPassword()
                )
                .role(
                        mapRoleToEntity(
                                user.getRole()
                        )
                )
                .build();
    }


    public User toDomain(
            UserEntity entity
    ) {

        return UserFactory.restore(
                new UserRestoreData(
                        new UserId(
                                entity.getId()
                        ),
                        entity.getName(),
                        entity.getLastName(),
                        new Document(
                                entity.getDocument()
                        ),
                        new Phone(
                                entity.getPhone()
                        ),
                        entity.getBirthDate(),
                        new Email(
                                entity.getEmail()
                        ),
                        entity.getPassword(),
                        mapRoleToDomain(
                                entity.getRole()
                        )
                )
        );
    }


    private RoleEntity mapRoleToEntity(
            Role role
    ) {

        return RoleEntity.valueOf(
                role.name()
        );
    }


    private Role mapRoleToDomain(
            RoleEntity roleEntity
    ) {

        return Role.valueOf(
                roleEntity.name()
        );
    }
}