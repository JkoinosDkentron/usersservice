package com.juanda.powerup.usersservice.infrastructure.exceptionhandler;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(
        description = "Standard error response returned by the API"
)
public record ErrorResponse(

        @Schema(
                description = "Timestamp when the error occurred",
                example = "2026-09-17T21:30:00"
        )
        LocalDateTime timestamp,


        @Schema(
                description = "HTTP status code",
                example = "400"
        )
        Integer status,


        @Schema(
                description = "HTTP status description",
                example = "Bad Request"
        )
        String error,


        @Schema(
                description = "Detailed error message",
                example = "User email format is invalid"
        )
        String message

) {
}