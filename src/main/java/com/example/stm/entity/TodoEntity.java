package com.example.stm.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Table(name = "todo")
@Entity
public class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
            private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String priority;
    @Column(nullable = false)
    private String status;

    @ManyToOne
    private UserEntity  assignee;

    @ManyToOne
    private UserEntity author;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "todo")
    private List<CommentEntity> comment_todo;

}

