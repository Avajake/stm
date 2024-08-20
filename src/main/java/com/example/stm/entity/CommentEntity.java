package com.example.stm.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.time.LocalDateTime;

@Data
@Table(name = "comments")
@Entity
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private TodoEntity todo;
    @ManyToOne
    private UserEntity user;
    private String comment;


    private LocalDateTime createdAt;
}
