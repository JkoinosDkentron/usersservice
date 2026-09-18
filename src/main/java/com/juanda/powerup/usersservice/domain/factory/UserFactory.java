package com.juanda.powerup.usersservice.domain.factory;


import com.juanda.powerup.usersservice.domain.model.*;
import com.juanda.powerup.usersservice.domain.model.valueobject.Document;
import com.juanda.powerup.usersservice.domain.model.valueobject.Email;
import com.juanda.powerup.usersservice.domain.model.valueobject.Phone;
import com.juanda.powerup.usersservice.domain.model.valueobject.UserId;
import com.juanda.powerup.usersservice.domain.validation.UserValidator;


public final class UserFactory {


    private UserFactory() {
    }


    public static User createOwner(
            CreateOwnerData data
    ) {

        UserValidator.validateOwner(
                data.name(),
                data.lastName(),
                data.birthDate(),
                data.password()
        );


        return new User(
                new UserData(
                        new UserId(data.id()),
                        data.name(),
                        data.lastName(),
                        new Document(data.document()),
                        new Phone(data.phone()),
                        data.birthDate(),
                        new Email(data.email()),
                        data.password(),
                        Role.OWNER
                )
        );
    }

    public static User restore(
            UserRestoreData data
    ) {

        return new User(
                new UserData(
                        data.id(),
                        data.name(),
                        data.lastName(),
                        data.document(),
                        data.phone(),
                        data.birthDate(),
                        data.email(),
                        data.password(),
                        data.role()
                )
        );
    }
}