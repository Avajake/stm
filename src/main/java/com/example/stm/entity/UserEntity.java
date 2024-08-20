package com.example.stm.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Table(name = "users")
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String role;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    private List<TodoEntity> todo_author;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "assignee")
    private List<TodoEntity> todo_assignee;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<CommentEntity> comment_user;
}
