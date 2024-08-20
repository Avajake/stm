package com.example.stm.repository;

import com.example.stm.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TodoRepo extends JpaRepository<TodoEntity,Long> {
    Optional<TodoEntity> findById(Long id);
}
