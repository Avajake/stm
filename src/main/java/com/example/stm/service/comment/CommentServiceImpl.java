package com.example.stm.service.comment;

import com.example.stm.entity.CommentEntity;
import com.example.stm.entity.TodoEntity;
import com.example.stm.entity.UserEntity;
import com.example.stm.modul.Comment;
import com.example.stm.modul.Todo;
import com.example.stm.repository.CommentRepo;
import com.example.stm.repository.TodoRepo;
import com.example.stm.repository.UserRepo;
import com.example.stm.response.TodoNotFoundException;
import com.example.stm.response.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepo commentRepo;
    @Autowired
    private TodoRepo todoRepo;
    @Autowired
    private UserRepo userRepo;

    @Override
    public List<Comment> getCommentsByTodoId(Long todoId) throws TodoNotFoundException {
        List<CommentEntity> commentEntities = commentRepo.findByTodoId(todoId);
        return commentEntities.stream().map(Comment::toModel).collect(Collectors.toList());
    }

    @Override
    public Comment createComment(Long todoId,Long user_id, CommentEntity commentEntity) throws UserNotFoundException, TodoNotFoundException {
        TodoEntity todo = todoRepo.findById(todoId).orElse(null);
        if (todo == null) {
            throw new TodoNotFoundException("Данной задачи нет!");
        }
        UserEntity user = userRepo.findById(user_id).orElse(null);
        if (user == null) {
            throw  new UserNotFoundException("Такого пользователя нет!");
        }
        commentEntity.setTodo(todo);
        commentEntity.setUser(user);
        commentEntity.setCreatedAt(LocalDateTime.now());
        return Comment.toModel(commentRepo.save(commentEntity));
    }
}
