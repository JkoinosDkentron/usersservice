package com.juanda.powerup.usersservice.domain.usecase;

import com.juanda.powerup.usersservice.domain.model.Role;
import com.juanda.powerup.usersservice.domain.model.User;
import com.juanda.powerup.usersservice.domain.spi.IPasswordEncoderPort;
import com.juanda.powerup.usersservice.domain.spi.IUserPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserUseCaseTest {

    private static final UUID USER_ID = UUID.randomUUID();

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
    void shouldReturnTrueWhenUserIsOwner() {

        User owner = User.restore(
                USER_ID,
                "Juan",
                "Vargas",
                "123456",
                "+573001234567",
                LocalDate.of(2000, 1, 1),
                "juan@test.com",
                "encrypted",
                Role.OWNER
        );

        when(userPersistencePort.findById(USER_ID))
                .thenReturn(Optional.of(owner));

        boolean result = userUseCase.isOwner(USER_ID);

        assertTrue(result);

        verify(userPersistencePort)
                .findById(USER_ID);
    }

    @Test
    void shouldReturnFalseWhenUserIsNotOwner() {

        User client = User.restore(
                USER_ID,
                "Juan",
                "Vargas",
                "123456",
                "+573001234567",
                LocalDate.of(2000, 1, 1),
                "juan@test.com",
                "encrypted",
                Role.CLIENT
        );

        when(userPersistencePort.findById(USER_ID))
                .thenReturn(Optional.of(client));

        boolean result = userUseCase.isOwner(USER_ID);

        assertFalse(result);

        verify(userPersistencePort)
                .findById(USER_ID);
    }

    @Test
    void shouldReturnFalseWhenUserDoesNotExist() {

        when(userPersistencePort.findById(USER_ID))
                .thenReturn(Optional.empty());

        boolean result = userUseCase.isOwner(USER_ID);

        assertFalse(result);

        verify(userPersistencePort)
                .findById(USER_ID);
    }

    @Test
    void shouldCreateOwnerWithEncodedPassword() {

        User owner = User.createOwner(
                USER_ID,
                "Juan",
                "Vargas",
                "123456",
                "+573001234567",
                LocalDate.of(2000, 1, 1),
                "juan@test.com",
                "plain-password"
        );

        when(passwordEncoderPort.encode("plain-password"))
                .thenReturn("encoded-password");

        when(userPersistencePort.save(org.mockito.ArgumentMatchers.any(User.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        User result = userUseCase.createOwner(owner);

        assertEquals(
                "encoded-password",
                result.getPassword()
        );

        verify(passwordEncoderPort)
                .encode("plain-password");

        verify(userPersistencePort)
                .save(org.mockito.ArgumentMatchers.argThat(
                        user -> "encoded-password".equals(user.getPassword())
                ));
    }
}