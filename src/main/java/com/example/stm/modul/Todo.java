package com.example.stm.modul;

import com.example.stm.entity.TodoEntity;
import lombok.Data;

import java.util.List;

@Data
public class Todo {
    private Long id;
    private String title;
    private String description;
    private String priority;
    private String status;
    private User assignee;

    public static Todo toModel(TodoEntity todoEntity){
        Todo todo = new Todo();
        todo.setId(todoEntity.getId());
        todo.setTitle(todoEntity.getTitle());
        todo.setPriority(todoEntity.getPriority());
        todo.setDescription(todoEntity.getDescription());
        todo.setStatus(todoEntity.getStatus());

        todo.setAssignee(User.toModel(todoEntity.getAssignee()));
        return todo;
    }
}
