package com.example.stm.modul;

import com.example.stm.entity.CommentEntity;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Comment {
    private Long id;
    private String comment;

    private LocalDateTime createdAt;

    public static Comment toModel(CommentEntity commentEntity){
        Comment comment = new Comment();
        comment.setId(commentEntity.getId());
        comment.setComment(commentEntity.getComment());
        comment.setCreatedAt(commentEntity.getCreatedAt());

        return comment;
    }
}
