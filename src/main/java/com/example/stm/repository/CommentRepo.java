package com.example.stm.repository;

import com.example.stm.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepo extends JpaRepository<CommentEntity,Long> {
    List<CommentEntity> findByTodoId(Long todoId);
}
