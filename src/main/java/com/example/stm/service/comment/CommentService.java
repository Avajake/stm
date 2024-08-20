package com.example.stm.service.comment;

import com.example.stm.entity.CommentEntity;
import com.example.stm.modul.Comment;
import com.example.stm.response.TodoNotFoundException;
import com.example.stm.response.UserNotFoundException;

import java.util.List;

public interface CommentService {
    List<Comment> getCommentsByTodoId(Long todoId) throws TodoNotFoundException;
    Comment createComment(Long todoId, Long user_id, CommentEntity commentEntity) throws UserNotFoundException, TodoNotFoundException;
}
