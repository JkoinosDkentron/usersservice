package com.juanda.powerup.usersservice.application;

import com.juanda.powerup.usersservice.application.dto.request.CreateOwnerRequest;
import com.juanda.powerup.usersservice.application.dto.response.CreateOwnerResponse;
import com.juanda.powerup.usersservice.application.handler.CreateOwnerHandler;
import com.juanda.powerup.usersservice.domain.api.IUserServicePort;
import com.juanda.powerup.usersservice.domain.model.User;
import com.juanda.powerup.usersservice.domain.spi.IPasswordEncoderPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateOwnerHandlerTest {

    private static final LocalDate ADULT_BIRTH_DATE =
            LocalDate.now(ZoneId.systemDefault())
                    .minusYears(20);

    @Mock
    private IUserServicePort userServicePort;

    @Mock
    private IPasswordEncoderPort passwordEncoderPort;

    @InjectMocks
    private CreateOwnerHandler createOwnerHandler;

    @Test
    void shouldCreateOwnerWithEncryptedPassword() {

        CreateOwnerRequest request = new CreateOwnerRequest(
                "Juan",
                "Vargas",
                "123456",
                "+573001234567",
                ADULT_BIRTH_DATE,
                "juan@test.com",
                "123456"
        );


        when(passwordEncoderPort.encode("123456"))
                .thenReturn("encrypted");


        User owner = User.createOwner(
                UUID.randomUUID(),
                "Juan",
                "Vargas",
                "123456",
                "+573001234567",
                ADULT_BIRTH_DATE,
                "juan@test.com",
                "encrypted"
        );


        when(userServicePort.createOwner(any(User.class)))
                .thenReturn(owner);


        CreateOwnerResponse response =
                createOwnerHandler.createOwner(request);


        assertNotNull(response.id());


        verify(passwordEncoderPort)
                .encode("123456");


        verify(userServicePort)
                .createOwner(any(User.class));

    }
}
