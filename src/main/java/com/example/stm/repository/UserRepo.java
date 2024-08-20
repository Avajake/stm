package com.example.stm.repository;

import com.example.stm.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findById(Long id);

    Optional<UserEntity> findByUsername(String username);
    Optional<UserEntity> findByEmail(String email);
}
