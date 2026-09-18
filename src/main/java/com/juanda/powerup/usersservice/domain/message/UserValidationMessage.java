package com.juanda.powerup.usersservice.domain.message;

public final class UserValidationMessage {

    private UserValidationMessage(){
    }


    public static final String NAME_REQUIRED =
            "User name is required";

    public static final String LAST_NAME_REQUIRED =
            "User last name is required";

    public static final String DOCUMENT_REQUIRED =
            "User document is required";

    public static final String DOCUMENT_NUMERIC =
            "User document must be numeric";

    public static final String PHONE_REQUIRED =
            "User phone is required";

    public static final String PHONE_FORMAT =
            "User phone format is invalid";

    public static final String PHONE_MAX_LENGTH =
            "User phone cannot exceed 13 characters";

    public static final String BIRTH_DATE_REQUIRED =
            "User birth date is required";

    public static final String EMAIL_REQUIRED =
            "User email is required";

    public static final String EMAIL_FORMAT =
            "User email format is invalid";

    public static final String PASSWORD_REQUIRED =
            "User password is required";

    public static final String USER_MUST_BE_ADULT =
            "User must be adult";

    public static final String USER_ID_NOT_NULL =
            "User id cannot be null";

    public static final String USER_DATA_NOT_NULL =
            "User data cannot be null";
}