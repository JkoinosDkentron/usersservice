package com.juanda.powerup.usersservice.infrastructure.out.jpa.repository;

import com.juanda.powerup.usersservice.infrastructure.out.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserJpaRepository extends JpaRepository<UserEntity, UUID> {

}