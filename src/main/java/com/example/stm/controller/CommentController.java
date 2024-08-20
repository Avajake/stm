package com.example.stm.controller;

import com.example.stm.entity.CommentEntity;
import com.example.stm.entity.TodoEntity;
import com.example.stm.repository.UserRepo;
import com.example.stm.response.TodoNotFoundException;
import com.example.stm.service.comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v3/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/{todoId}/comments")
    public ResponseEntity getCommentsByTaskId(@PathVariable Long todoId) throws TodoNotFoundException {
        try {
            return ResponseEntity.ok().body(commentService.getCommentsByTodoId(todoId));
        }
        catch (Exception e) {
            return  ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PostMapping("/{todoId}")
    public ResponseEntity createComment(@PathVariable Long todoId,@RequestParam Long user_id ,@RequestBody CommentEntity commentEntity) {
        try {
            return ResponseEntity.ok().body(commentService.createComment(todoId,user_id,commentEntity));
        }
        catch (Exception e) {
            return  ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

}
