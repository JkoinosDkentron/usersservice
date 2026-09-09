package com.juanda.powerup.users_service.domain.port.out;

import com.juanda.powerup.users_service.domain.model.User;

public interface UserRepositoryPort {

    User save(User user);
}
