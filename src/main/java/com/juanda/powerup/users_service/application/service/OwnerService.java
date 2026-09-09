package com.juanda.powerup.users_service.application.service;

import com.juanda.powerup.users_service.domain.usecase.CreateOwnerUseCase;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {

    private final CreateOwnerUseCase createOwnerUseCase;

    public OwnerService(CreateOwnerUseCase createOwnerUseCase) {
        this.createOwnerUseCase = createOwnerUseCase;
    }

    public Object createOwner(Object createOwnerUseCase) {

    }

}
