package com.juanda.powerup.usersservice.application.handler;


import com.juanda.powerup.usersservice.application.dto.request.CreateOwnerRequest;
import com.juanda.powerup.usersservice.application.dto.response.CreateOwnerResponse;
import com.juanda.powerup.usersservice.application.handler.impl.UserHandler;
import com.juanda.powerup.usersservice.application.mapper.IUserRequestMapper;
import com.juanda.powerup.usersservice.application.mapper.IUserResponseMapper;
import com.juanda.powerup.usersservice.domain.api.IUserServicePort;
import com.juanda.powerup.usersservice.domain.model.User;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.UUID;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class UserHandlerTest {


    private static final LocalDate ADULT_BIRTH_DATE =
            LocalDate.now(ZoneId.systemDefault())
                    .minusYears(20);


    @Mock
    private IUserServicePort userServicePort;


    @Mock
    private IUserRequestMapper userRequestMapper;


    @Mock
    private IUserResponseMapper userResponseMapper;


    @InjectMocks
    private UserHandler userHandler;



    @Test
    void shouldCreateOwnerSuccessfully() {


        CreateOwnerRequest request =
                new CreateOwnerRequest(
                        "Juan",
                        "Vargas",
                        "123456",
                        "+573001234567",
                        ADULT_BIRTH_DATE,
                        "juan@test.com",
                        "123456"
                );


        User owner =
                User.createOwner(
                        UUID.randomUUID(),
                        "Juan",
                        "Vargas",
                        "123456",
                        "+573001234567",
                        ADULT_BIRTH_DATE,
                        "juan@test.com",
                        "encrypted"
                );


        CreateOwnerResponse response =
                new CreateOwnerResponse(
                        owner.getId()
                );



        when(userRequestMapper.toDomain(request))
                .thenReturn(owner);


        when(userServicePort.createOwner(owner))
                .thenReturn(owner);


        when(userResponseMapper.toResponse(owner))
                .thenReturn(response);



        CreateOwnerResponse result =
                userHandler.createOwner(request);



        assertNotNull(result.id());


        verify(userRequestMapper)
                .toDomain(request);


        verify(userServicePort)
                .createOwner(owner);


        verify(userResponseMapper)
                .toResponse(owner);

    }
}