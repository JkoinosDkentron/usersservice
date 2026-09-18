package com.juanda.powerup.usersservice.application.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;


@Schema(
        description = "Response generated after creating an owner user"
)
public record CreateOwnerResponse(


        @Schema(
                description = "Generated user identifier",
                example = "550e8400-e29b-41d4-a716-446655440000"
        )
        UUID id

) {
}