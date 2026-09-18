package com.juanda.powerup.usersservice.infrastructure.security;

import com.juanda.powerup.usersservice.domain.spi.IPasswordEncoderPort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BCryptPasswordEncoderAdapter implements IPasswordEncoderPort {


    private final PasswordEncoder passwordEncoder;


    public BCryptPasswordEncoderAdapter(
            PasswordEncoder passwordEncoder
    ) {
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public String encode(String password) {

        return passwordEncoder.encode(password);
    }
}