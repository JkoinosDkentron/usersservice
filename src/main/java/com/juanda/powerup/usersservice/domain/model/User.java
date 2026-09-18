package com.juanda.powerup.usersservice.domain.model;

import com.juanda.powerup.usersservice.domain.exception.InvalidUserException;
import com.juanda.powerup.usersservice.domain.model.valueobject.Document;
import com.juanda.powerup.usersservice.domain.model.valueobject.Email;
import com.juanda.powerup.usersservice.domain.model.valueobject.Phone;
import com.juanda.powerup.usersservice.domain.model.valueobject.UserId;

import java.time.LocalDate;

import static com.juanda.powerup.usersservice.domain.message.UserValidationMessage.USER_DATA_NOT_NULL;
import static com.juanda.powerup.usersservice.domain.message.UserValidationMessage.USER_ID_NOT_NULL;


public class User {


    private UserId id;

    private String name;

    private String lastName;

    private Document document;

    private Phone phone;

    private LocalDate birthDate;

    private Email email;

    private String password;

    private Role role;


    public User(UserData data) {


        if (data == null) {

            throw new InvalidUserException(
                    USER_DATA_NOT_NULL
            );
        }


        if (data.id() == null) {

            throw new InvalidUserException(
                    USER_ID_NOT_NULL
            );
        }


        this.id = data.id();

        this.name = data.name();

        this.lastName = data.lastName();

        this.document = data.document();

        this.phone = data.phone();

        this.birthDate = data.birthDate();

        this.email = data.email();

        this.password = data.password();

        this.role = data.role();
    }


    public UserId getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public String getLastName() {
        return lastName;
    }


    public Document getDocument() {
        return document;
    }


    public Phone getPhone() {
        return phone;
    }


    public LocalDate getBirthDate() {
        return birthDate;
    }


    public Email getEmail() {
        return email;
    }


    public String getPassword() {
        return password;
    }


    public Role getRole() {
        return role;
    }
}