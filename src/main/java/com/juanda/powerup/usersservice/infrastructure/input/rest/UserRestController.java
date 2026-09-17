package com.juanda.powerup.usersservice.infrastructure.input.rest;

import com.juanda.powerup.usersservice.application.dto.request.CreateOwnerRequest;
import com.juanda.powerup.usersservice.application.dto.response.CreateOwnerResponse;
import com.juanda.powerup.usersservice.application.dto.response.OwnerValidationResponse;
import com.juanda.powerup.usersservice.application.handler.IUserHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserRestController {

    private final IUserHandler userHandler;

    @PostMapping("/owners")
    public ResponseEntity<CreateOwnerResponse> createOwner(
            @Valid @RequestBody CreateOwnerRequest request
    ) {

        return ResponseEntity.ok(
                userHandler.createOwner(request)
        );
    }

    @GetMapping("/{userId}/owner")
    public ResponseEntity<OwnerValidationResponse> isOwner(
            @PathVariable UUID userId
    ) {
        return ResponseEntity.ok(
                userHandler.isOwner(userId)
        );
    }
}

