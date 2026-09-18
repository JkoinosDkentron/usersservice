package com.juanda.powerup.usersservice.infrastructure.input.rest;

import com.juanda.powerup.usersservice.application.dto.request.CreateOwnerRequest;
import com.juanda.powerup.usersservice.application.dto.response.CreateOwnerResponse;
import com.juanda.powerup.usersservice.application.handler.IUserHandler;
import com.juanda.powerup.usersservice.infrastructure.exceptionhandler.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Tag(
        name = "Users",
        description = "Endpoints for user management"
)
public class UserRestController {


    private final IUserHandler userHandler;


    @Operation(
            summary = "Create owner",
            description = """
                    Creates a restaurant owner account.
                    The owner must provide valid personal information and
                    meet the minimum age requirement.
                    """
    )
    @ApiResponse(
            responseCode = "201",
            description = "Owner created successfully",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(
                            implementation = CreateOwnerResponse.class
                    )
            )
    )
    @ApiResponse(
            responseCode = "400",
            description = "Invalid owner data",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(
                            implementation = ErrorResponse.class
                    )
            )
    )
    @ApiResponse(
            responseCode = "500",
            description = "Unexpected server error",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(
                            implementation = ErrorResponse.class
                    )
            )
    )
    @PostMapping("/owners")
    public ResponseEntity<CreateOwnerResponse> createOwner(
            @Valid @RequestBody CreateOwnerRequest request
    ) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        userHandler.createOwner(request)
                );
    }
}