package com.juanda.powerup.usersservice.domain.usecase;

import com.juanda.powerup.usersservice.domain.model.CreateOwnerData;
import com.juanda.powerup.usersservice.domain.model.User;
import com.juanda.powerup.usersservice.domain.spi.IPasswordEncoderPort;
import com.juanda.powerup.usersservice.domain.spi.IUserPersistencePort;
import com.juanda.powerup.usersservice.mother.UserMother;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class UserUseCaseTest {


    @Mock
    private IUserPersistencePort userPersistencePort;


    @Mock
    private IPasswordEncoderPort passwordEncoderPort;


    private UserUseCase userUseCase;


    @BeforeEach
    void setUp() {

        userUseCase = new UserUseCase(
                userPersistencePort,
                passwordEncoderPort
        );
    }


    @Test
    void shouldCreateOwnerEncryptPasswordAndSaveUser() {


        CreateOwnerData data =
                new CreateOwnerData(
                        UserMother.randomId(),
                        "Juan",
                        "Vargas",
                        "123456",
                        "+573001234567",
                        UserMother.adultBirthDate(),
                        "juan@test.com",
                        "123456"
                );


        String encryptedPassword =
                "encrypted-password";


        when(passwordEncoderPort.encode("123456"))
                .thenReturn(encryptedPassword);


        ArgumentCaptor<User> userCaptor =
                ArgumentCaptor.forClass(User.class);


        when(userPersistencePort.save(any(User.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));


        User result =
                userUseCase.createOwner(data);


        assertEquals(
                encryptedPassword,
                result.getPassword()
        );


        verify(passwordEncoderPort)
                .encode("123456");


        verify(userPersistencePort)
                .save(userCaptor.capture());


        User savedUser =
                userCaptor.getValue();


        assertEquals(
                encryptedPassword,
                savedUser.getPassword()
        );


        assertEquals(
                "Juan",
                savedUser.getName()
        );
    }
}