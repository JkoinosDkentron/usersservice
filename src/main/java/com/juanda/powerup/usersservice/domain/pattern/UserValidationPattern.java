package com.juanda.powerup.usersservice.domain.pattern;


public final class UserValidationPattern {


    private UserValidationPattern() {
    }


    public static final String PHONE_PATTERN =
            "^\\+?\\d{1,12}$";


    public static final String EMAIL_PATTERN =
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";


    public static final String DOCUMENT_PATTERN =
            "^\\d+$";
}