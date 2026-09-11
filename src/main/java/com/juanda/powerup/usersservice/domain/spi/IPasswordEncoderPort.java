package com.juanda.powerup.usersservice.domain.spi;

public interface IPasswordEncoderPort {

    String encode(String password);
}
