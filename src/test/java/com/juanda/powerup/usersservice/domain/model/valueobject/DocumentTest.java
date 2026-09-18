package com.juanda.powerup.usersservice.domain.model.valueobject;


import com.juanda.powerup.usersservice.domain.exception.InvalidUserException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class DocumentTest {


    @Test
    void shouldCreateDocumentWithValidNumber() {


        Document document =
                new Document("123456789");


        assertEquals(
                "123456789",
                document.value()
        );
    }


    @Test
    void shouldThrowExceptionWhenDocumentIsNull() {


        assertThrows(
                InvalidUserException.class,
                () -> new Document(null)
        );
    }


    @Test
    void shouldThrowExceptionWhenDocumentIsEmpty() {


        assertThrows(
                InvalidUserException.class,
                () -> new Document("")
        );
    }


    @Test
    void shouldThrowExceptionWhenDocumentIsNotNumeric() {


        assertThrows(
                InvalidUserException.class,
                () -> new Document("123ABC")
        );
    }
}