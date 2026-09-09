package com.juanda.powerup.users_service.domain.port.out;

import com.juanda.powerup.users_service.domain.model.UserId;

public interface IdGeneratorPort {

    UserId generate();

}
