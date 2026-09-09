package com.juanda.powerup.users_service.domain.usecase;

import com.juanda.powerup.users_service.application.dto.CreateOwnerCommand;
import com.juanda.powerup.users_service.domain.model.User;
import com.juanda.powerup.users_service.domain.model.UserId;
import com.juanda.powerup.users_service.domain.port.out.IdGeneratorPort;
import com.juanda.powerup.users_service.domain.port.out.UserRepositoryPort;

public class CreateOwnerUseCase {

    private final IdGeneratorPort idGenerator;
    private final UserRepositoryPort userRepository;

    public CreateOwnerUseCase(
            IdGeneratorPort idGenerator,
            UserRepositoryPort userRepository
    ) {
        this.idGenerator = idGenerator;
        this.userRepository = userRepository;
    }

    public UserId execute(CreateOwnerCommand command) {

        UserId id = idGenerator.generate();

        User user = User.createOwner(
                id,
                command.name(),
                command.lastName(),
                command.document(),
                command.phone(),
                command.birthDate(),
                command.email(),
                command.password()
        );

        userRepository.save(user);

        return id;
    }
}
