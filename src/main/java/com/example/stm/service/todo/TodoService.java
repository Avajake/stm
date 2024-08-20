package com.example.stm.service.todo;

import com.example.stm.entity.TodoEntity;
import com.example.stm.modul.Todo;
import com.example.stm.response.TodoNotFoundException;
import com.example.stm.response.UserNotFoundException;

import java.util.List;

public interface TodoService {
    Todo createTodo(TodoEntity todoEntity, Long user_id);
    Todo editTodo(TodoEntity todoEntity, Long id) throws TodoNotFoundException;
    Todo editStatus(Long id, String status) throws TodoNotFoundException;
    Todo editPriority(Long id, String priority) throws TodoNotFoundException;
    Todo assignTask(Long taskid, Long user_id) throws UserNotFoundException, TodoNotFoundException;
    List<Todo> getAll();
}
